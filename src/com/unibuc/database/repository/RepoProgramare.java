package com.unibuc.database.repository;

import com.unibuc.appointment.Programare;
import com.unibuc.database.config.DBConfig;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RepoProgramare {

    public Programare saveAppointmentGP(Programare prog) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into programari_med_primar" +
                    "(id_medic, id_pacient, data, ora, diagnostic) " +
                    "VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prog.getAssignedDoctor().getIdMedic());
            preparedStatement.setInt(2, prog.getPatient().getIdPacient());
            preparedStatement.setDate(3, (Date) prog.getDateOfAppointment());
            preparedStatement.setObject(4, prog.getTimeOfAppointment(),JDBCType.TIME);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                prog.setIdProgramare(resultSet.getInt(1));
            }
            resultSet.close();
            return prog;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving App with GP: " + prog);
        }
    }

    public Programare saveAppointmentNurse(Programare prog) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into programari_asist" +
                    "(id_medic, id_pacient, data, ora, diagnostic) " +
                    "VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prog.getAssignedDoctor().getIdMedic());
            preparedStatement.setInt(2, prog.getPatient().getIdPacient());
            preparedStatement.setDate(3, (Date) prog.getDateOfAppointment());
            preparedStatement.setObject(4, prog.getTimeOfAppointment(),JDBCType.TIME);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                prog.setIdProgramare(resultSet.getInt(1));
            }
            resultSet.close();
            return prog;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving App with Nurse: " + prog);
        }
    }

    public Programare saveAppointmentPsych(Programare prog) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into programari_psih" +
                    "(id_medic, id_pacient, data, ora, diagnostic) " +
                    "VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prog.getAssignedDoctor().getIdMedic());
            preparedStatement.setInt(2, prog.getPatient().getIdPacient());
            preparedStatement.setDate(3, (Date) prog.getDateOfAppointment());
            preparedStatement.setObject(4, prog.getTimeOfAppointment(),JDBCType.TIME);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                prog.setIdProgramare(resultSet.getInt(1));
            }
            resultSet.close();
            return prog;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving App with Psych: " + prog);
        }
    }

//    public Programare findAppGPById(int id){
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "SELECT * FROM programari_med_primar WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1,id);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            if(resultSet.first()) {
//                return (mapToPacFiz(resultSet));
//            }
//            else return null;
//
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while tying to get Physical Patient by ID: ");
//        }
//    }

//
//    public boolean updatePatientPhysical(int id, String newAddress) {
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "UPDATE pacienti_fiz SET adresa = ? \n" +
//                    "WHERE id = ?";
//
//            PreparedStatement preparedStatement= connection.prepareStatement(query);
//            preparedStatement.setString(1,newAddress);
//            preparedStatement.setInt(2, id);
//
//            return preparedStatement.executeUpdate() != 0;
//
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while tying to update Physical Patient's (id = " + id + ") address");
//        }
//    }
//
//    public boolean updatePatientMental(int id, String newAddress) {
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "UPDATE pacienti_men SET adresa = ? \n" +
//                    "WHERE id = ?";
//
//            PreparedStatement preparedStatement= connection.prepareStatement(query);
//            preparedStatement.setString(1,newAddress);
//            preparedStatement.setInt(2, id);
//
//            return preparedStatement.executeUpdate() != 0;
//
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while tying to update Mental Patient's (id = " + id + ") address");
//        }
//    }
//
//    public boolean deletePatientPhysicalById(int id) {
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "DELETE FROM pacienti_fiz WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//
//            return preparedStatement.executeUpdate() != 0;
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while trying to delete Physical Patient " + id);
//        }
//    }
//
//    public boolean deletePatientMentalById(int id) {
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "DELETE FROM pacienti_men WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//
//            return preparedStatement.executeUpdate() != 0;
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while trying to delete Mental Patient " + id);
//        }
//    }
//
//    private Programare mapToProgGP(ResultSet resultSet) throws SQLException {
//        Programare pac = new Programare();
//        pac.setIdPacient(resultSet.getInt(1));
//        return pac;
//    }
//
//    private PacientSanatateMentala mapToPacMen(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {
//
//        Vector<String> med = new Vector<>();
//        while (resultSet2.next()) {
//            med.add(resultSet2.getString(2));
//        }
//
//        PacientSanatateMentala pac = new PacientSanatateMentala(resultSet1.getString(2),resultSet1.getString(3),resultSet1.getString(4),resultSet1.getString(5), resultSet1.getInt(6), resultSet1.getString(7),med.size(),med);
//        pac.setIdPacient(resultSet1.getInt(1));
//        return pac;
//    }
}

