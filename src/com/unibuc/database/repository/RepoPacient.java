package com.unibuc.database.repository;

import com.unibuc.database.config.DBConfig;
import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RepoPacient {

    public PacientSanatateFizica savePatientPhysical(PacientSanatateFizica pat) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into pacienti_fiz" +
                    "(nume, gen, adresa, varsta, cnp, card_sanatate) " +
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pat.getName());
            preparedStatement.setString(2, pat.getGender());
            preparedStatement.setString(3, pat.getAddress());
            preparedStatement.setInt(4, pat.getAge());
            preparedStatement.setString(5,pat.getIdCard());
            preparedStatement.setString(6,pat.getInsuranceID());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                pat.setIdPacient(resultSet.getInt(1));
            }
            resultSet.close();
            return pat;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving Physical Patient: " + pat);
        }
    }
    public PacientSanatateMentala savePatientMental(PacientSanatateMentala pat) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into pacienti_men" +
                    "(nume, gen, adresa, varsta, cnp, diagnostic_antecedent) " +
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pat.getName());
            preparedStatement.setString(2, pat.getGender());
            preparedStatement.setString(3, pat.getAddress());
            preparedStatement.setInt(4, pat.getAge());
            preparedStatement.setString(5,pat.getIdCard());
            preparedStatement.setString(6,pat.getPreviousDiagnostic());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                pat.setIdPacient(resultSet.getInt(1));
            }
            resultSet.close();

            String query1 = "INSERT into medicamente_men" +
                    "(id_pacient, nume_med) " +
                    "VALUES(?,?)";

            PreparedStatement preparedStatement1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            for(String med:pat.getMedication()){
                preparedStatement1.setInt(1, pat.getIdPacient());
                preparedStatement1.setString(2, med);
                preparedStatement1.execute();
            }

            return pat;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving Mental Patient: " + pat);
        }
    }

    public PacientSanatateFizica findPatientPhysicalById(int id) {
        PacientSanatateFizica med = null;
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM pacienti_fiz WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                med = new PacientSanatateFizica(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7));
                med.setIdPacient(resultSet.getInt(1));
            }
            resultSet.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to get Phys Pat " + id + exception.getMessage());
        }
        return med;
    }

    public PacientSanatateMentala findPatientMentalById(int id) {
        PacientSanatateMentala med = null;
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM pacienti_men WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            String query1 = "SELECT * FROM medicamente_men WHERE id_pacient=?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement1.setInt(1, id);
            ResultSet resultSet2 = preparedStatement1.executeQuery();
            //return (mapToPacMen(resultSet,resultSet2));

            Vector<String> meds = new Vector<>();

            while (resultSet2.next()) {
                meds.add(resultSet2.getString(2));
            }

            if (resultSet.next()) {
                med = new PacientSanatateMentala(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7),meds.size(),meds);
                med.setIdPacient(resultSet.getInt(1));
            }
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to get Men Pat " + id + exception.getMessage());
        }
    }
//
//    public PacientSanatateMentala findPatientMentalById(int id){
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "SELECT * FROM pacienti_men WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet1 = preparedStatement.executeQuery(query);
//            System.out.println("Da1");
//
//            String query1 = "SELECT * FROM medicamente_men WHERE id_pacient = ?";
//            PreparedStatement preparedStatement1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement1.setInt(1,id);
//            Statement statement1 = connection.createStatement();
//            ResultSet resultSet2 = statement1.executeQuery(query1);
//            System.out.println("Da2");
//
//
//            if(resultSet1.first()) {
//                return (mapToPacMen(resultSet1, resultSet2));
//            }
//            else return null;
//
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while tying to get Mental Patient by ID: "+exception);
//        }
//    }

    public List<PacientSanatateFizica> findAllPatientPhysical()
    {
        List<PacientSanatateFizica> med = new ArrayList<>();
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM pacienti_fiz";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                med.add(mapToPacFiz(resultSet));
            }

            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Physical Patients: ");
        }
    }

    public List<PacientSanatateMentala> findAllPatientMental()
    {
        List<PacientSanatateMentala> med = new ArrayList<>();
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM pacienti_men";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                    //PacientSanatateMentala medi = new PacientSanatateMentala(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7),3,new Vector<String>());
                    //medi.setIdPacient(resultSet.getInt(1));
                System.out.println(resultSet.getInt(1));
                String query1 = "SELECT * FROM medicamente_men WHERE id_pacient=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, resultSet.getInt(1));
                ResultSet resultSet2 = preparedStatement.executeQuery();
                med.add(mapToPacMen(resultSet,resultSet2));
//                Vector<String> meds = new Vector<>();
//
//                while (resultSet2.next()) {
//                    meds.add(resultSet2.getString(2));
//                }
//                System.out.println(meds);
                //med.add(medi);
            }

            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Mental Patients: "+exception.getMessage());
        }
    }

    public boolean updatePatientPhysical(int id, String newAddress) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "UPDATE pacienti_fiz SET adresa = ? \n" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,newAddress);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to update Physical Patient's (id = " + id + ") address");
        }
    }

    public boolean updatePatientMental(int id, String newAddress) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "UPDATE pacienti_men SET adresa = ? \n" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,newAddress);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to update Mental Patient's (id = " + id + ") address");
        }
    }

    public boolean deletePatientPhysicalById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM pacienti_fiz WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            System.out.println(id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete Physical Patient " + id);
        }
    }

    public boolean deletePatientMentalById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM pacienti_men WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete Mental Patient " + id);
        }
    }

    private PacientSanatateFizica mapToPacFiz(ResultSet resultSet) throws SQLException {
        PacientSanatateFizica pac = new PacientSanatateFizica(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getInt(6),resultSet.getString(7));
        pac.setIdPacient(resultSet.getInt(1));
        return pac;
    }

    private PacientSanatateMentala mapToPacMen(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {

        Vector<String> med = new Vector<>();

        while (resultSet2.next()) {
            med.add(resultSet2.getString(2));
        }

        PacientSanatateMentala pac = new PacientSanatateMentala(resultSet1.getString(2),resultSet1.getString(3),resultSet1.getString(4),resultSet1.getString(5), resultSet1.getInt(6), resultSet1.getString(7),med.size(),med);
        pac.setIdPacient(resultSet1.getInt(1));
        //System.out.println("Da3");
        return pac;
    }
}

