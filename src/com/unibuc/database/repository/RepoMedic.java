package com.unibuc.database.repository;

import com.unibuc.database.config.DBConfig;
import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoMedic {

    public MedicPrimar saveGP(MedicPrimar med) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into medici_primari" +
                    "(nume, gen, adresa, varsta," +
                    " salariu_baza, specializare, experienta) " +
                    "VALUES(?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, med.getName());
            preparedStatement.setString(2, med.getGender());
            preparedStatement.setString(3, med.getAddress());
            preparedStatement.setInt(4, med.getAge());
            preparedStatement.setDouble(5,med.getBaseSalary());
            preparedStatement.setString(6,med.getSpecialisation());
            preparedStatement.setInt(7,med.getExperienceLevel());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                med.setIdMedic(resultSet.getInt(1));
            }
            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving GP: " + med);
        }
    }

    public Asistent saveNurse(Asistent med) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into asistenti" +
                    "(nume, gen, adresa, varsta," +
                    " salariu_baza, experienta) " +
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, med.getName());
            preparedStatement.setString(2, med.getGender());
            preparedStatement.setString(3, med.getAddress());
            preparedStatement.setInt(4, med.getAge());
            preparedStatement.setDouble(5,med.getBaseSalary());
            preparedStatement.setInt(6,med.getExperienceLevel());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                med.setIdMedic(resultSet.getInt(1));
            }
            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving Nurse: " + med);
        }
    }

    public Psihiatru savePsych(Psihiatru med) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into psihiatri" +
                    "(nume, gen, adresa, varsta," +
                    " salariu_baza, experienta) " +
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, med.getName());
            preparedStatement.setString(2, med.getGender());
            preparedStatement.setString(3, med.getAddress());
            preparedStatement.setInt(4, med.getAge());
            preparedStatement.setDouble(5,med.getBaseSalary());
            preparedStatement.setInt(6,med.getExperienceLevel());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                med.setIdMedic(resultSet.getInt(1));
            }
            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving psych: " + med);
        }
    }

//    public MedicPrimar findGPById(int id){
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "SELECT * FROM medici_primari WHERE id=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1,id);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            if(resultSet.next()) {
//                return (mapToMedicPrimar(resultSet));
//            }
//            else return null;
//
//        } catch (SQLException exception) {
//            throw new RuntimeException("Something went wrong while tying to get GP by ID: ");
//        }
//    }

    public MedicPrimar findGPById(int id) {
        MedicPrimar med = null;
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM medici_primari WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                med = new MedicPrimar(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getString(7),resultSet.getInt(8));
                med.setIdMedic(resultSet.getInt("id"));
            }
            resultSet.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to get GP " + id + exception.getMessage());
        }
        return med;
    }

    public Asistent findNurseById(int id) {
        Asistent med = null;
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM asistenti WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                med = new Asistent(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6),resultSet.getInt(8));
                med.setIdMedic(resultSet.getInt("id"));
            }
            resultSet.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to get Nurse " + id + exception.getMessage());
        }
        return med;
    }

    public Psihiatru findPsychById(int id) {
        Psihiatru med = null;
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM psihiatri WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                med = new Psihiatru(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6),resultSet.getInt(8));
                med.setIdMedic(resultSet.getInt("id"));
            }
            resultSet.close();
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to get Psych " + id + exception.getMessage());
        }
        return med;
    }


    public List<MedicPrimar> findAllGPs() {
        List<MedicPrimar> med = new ArrayList<>();
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM medici_primari";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                med.add(mapToMedicPrimar(resultSet));
            }

            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all GPs: ");
        }
    }

    public List<Asistent> findAllNurses() {
        List<Asistent> med = new ArrayList<>();
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM asistenti";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                med.add(mapToAsistent(resultSet));
            }

            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all nurses: ");
        }
    }

    public List<Psihiatru> findAllPsych() {
        List<Psihiatru> med = new ArrayList<>();
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "SELECT * FROM psihiatri";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                med.add(mapToPsihiatru(resultSet));
            }

            resultSet.close();
            return med;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all psychs: ");
        }
    }

    public boolean updateGP(int id, String newAddress) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "UPDATE medici_primari SET adresa = ? \n" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,newAddress);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to update the GP's (id = " + id + ") address");
        }
    }

    public boolean updateNurse(int id, String newAddress) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "UPDATE asistenti SET adresa = ? \n" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,newAddress);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to update the Nurse's (id = " + id + ") address");
        }
    }

    public boolean updatePsych(int id, String newAddress) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "UPDATE psihiatri SET adresa = ? \n" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,newAddress);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to update the Psych's (id = " + id + ") address");
        }
    }

    public boolean deleteGPById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM medici_primari WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete GP " + id);
        }
    }

    public boolean deleteNurseById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM asistenti WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete Nurse " + id);
        }
    }

    public boolean deletePsychById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM psihiatri WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete Pysch " + id);
        }
    }

    private MedicPrimar mapToMedicPrimar(ResultSet resultSet) throws SQLException {
        MedicPrimar med = new MedicPrimar(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getString(7), resultSet.getInt(8));
        med.setIdMedic(resultSet.getInt(1));
        return med;
    }

    private Asistent mapToAsistent(ResultSet resultSet) throws SQLException {
        Asistent med = new Asistent(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getInt(8));
        med.setIdMedic(resultSet.getInt(1));
        return med;
    }

    private Psihiatru mapToPsihiatru(ResultSet resultSet) throws SQLException {
        Psihiatru med = new Psihiatru(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getInt(8));
        med.setIdMedic(resultSet.getInt(1));
        return med;
    }
}

