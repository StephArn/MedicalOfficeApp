package com.unibuc.database.repository;

import com.unibuc.appointment.Programare;
import com.unibuc.database.config.DBConfig;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;
import com.unibuc.services.ServiceMedic;
import com.unibuc.services.ServicePacient;


import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RepoProgramare {

    public Programare saveAppointmentGP(Programare prog) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into programari_med_primar" +
                    "(id_medic, id_pacient, data, ora, diagnostic) " +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prog.getAssignedDoctor().getIdMedic());
            preparedStatement.setInt(2, prog.getPatient().getIdPacient());
            preparedStatement.setDate(3,  prog.getDateOfAppointment());
            preparedStatement.setObject(4, prog.getTimeOfAppointment(),JDBCType.TIME);
            preparedStatement.setString(5,prog.getDiagnostic());

            System.out.println(preparedStatement);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                prog.setIdProgramare(resultSet.getInt(1));
            }
            resultSet.close();
            return prog;

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while saving App with GP: " + exception.getMessage());
        }
    }

    public Programare saveAppointmentNurse(Programare prog) {

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "INSERT into programari_asist" +
                    "(id_medic, id_pacient, data, ora, diagnostic) " +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prog.getAssignedDoctor().getIdMedic());
            preparedStatement.setInt(2, prog.getPatient().getIdPacient());
            preparedStatement.setDate(3, (Date) prog.getDateOfAppointment());
            preparedStatement.setObject(4, prog.getTimeOfAppointment(),JDBCType.TIME);
            preparedStatement.setString(5,prog.getDiagnostic());

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
                    "VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prog.getAssignedDoctor().getIdMedic());
            preparedStatement.setInt(2, prog.getPatient().getIdPacient());
            preparedStatement.setDate(3, (Date) prog.getDateOfAppointment());
            preparedStatement.setObject(4, prog.getTimeOfAppointment(),JDBCType.TIME);
            preparedStatement.setString(5,prog.getDiagnostic());

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

    public boolean deleteAppGPById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM programari_med_primar WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete GP APP " + exception.getMessage());
        }
    }

    public boolean deleteAppNurseById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM programari_asist WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete Nurse APP " + exception.getMessage());
        }
    }

    public boolean deleteAppPsychById(int id) {
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            String query = "DELETE FROM programari_psih WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while trying to delete Psych APP " + exception.getMessage());
        }
    }

//    public List<Programare> findAllAppGP()
//    {
//        List<Programare> med = new ArrayList<>();
//        try (Connection connection = DBConfig.getDatabaseConnection()) {
//            String query = "SELECT * FROM programari_med_primar";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            ServiceMedic serviceMedic = ServiceMedic.getInstance();
//            ServicePacient servicePacient = ServicePacient.getInstance();
//
//            while (resultSet.next()) {
//
//                Programare pac = new Programare(serviceMedic.getGPFromDBById(resultSet.getInt(2)), servicePacient.getPatPhysFromDBById(resultSet.getInt(3)), resultSet.getString(4),resultSet.getDate(5), (LocalTime) resultSet.getObject(6));
//                pac.setIdProgramare(resultSet.getInt(1));
//                med.add(pac);
//            }
//
//            resultSet.close();
//
//
//        } catch (SQLException exception) {
//            //throw new RuntimeException("Something went wrong while tying to get all GP Apps: " + exception.printStackTrace());
//            exception.printStackTrace();
//        }
//        return med;
//    }

//    private Programare mapToProgGP(ResultSet resultSet) throws SQLException {
//        ServicePacient servicePacient = ServicePacient.getInstance();
//        ServiceMedic serviceMedic = ServiceMedic.getInstance();
//
//        //return pac;
//    }


}

