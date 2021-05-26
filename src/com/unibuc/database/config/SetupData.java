package com.unibuc.database.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupData {

    public void setup(){
        createGPTable();
        createNurseTable();
        createPsychTable();
        createPatientPhysicalTable();
        createPatientMentalTable();
        createMedsTable();
        createAppointmentGPTable();
        createAppointmentNurseTable();
        createAppointmentPsychTable();
    }
    private void createGPTable() {
        String query = "CREATE TABLE IF NOT EXISTS medici_primari (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    nume VARCHAR(255),\n" +
                "    gen VARCHAR(255),\n" +
                "    adresa VARCHAR(255),\n" +
                "    varsta INT,\n" +
                "   salariu_baza DOUBLE,\n" +
                "   specializare VARCHAR(255),\n"+
                "   experienta INT\n"+
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createNurseTable(){
        String query = "CREATE TABLE IF NOT EXISTS asistenti (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    nume VARCHAR(255),\n" +
                "    gen VARCHAR(255),\n" +
                "    adresa VARCHAR(255),\n" +
                "    varsta INT,\n" +
                "   salariu_baza DOUBLE,\n" +
                "   experienta INT\n"+
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createPsychTable(){
        String query = "CREATE TABLE IF NOT EXISTS psihiatri (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    nume VARCHAR(255),\n" +
                "    gen VARCHAR(255),\n" +
                "    adresa VARCHAR(255),\n" +
                "    varsta INT,\n" +
                "   salariu_baza DOUBLE,\n" +
                "   experienta INT\n"+
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createPatientPhysicalTable(){
        String query = "CREATE TABLE IF NOT EXISTS pacienti_fiz (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    nume VARCHAR(255),\n" +
                "    gen VARCHAR(255),\n" +
                "    adresa VARCHAR(255),\n" +
                "    varsta INT,\n" +
                "    cnp VARCHAR(255),\n" +
                "    card_sanatate VARCHAR(255)\n" +
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createPatientMentalTable(){
        String query = "CREATE TABLE IF NOT EXISTS pacienti_men (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    nume VARCHAR(255),\n" +
                "    gen VARCHAR(255),\n" +
                "    adresa VARCHAR(255),\n" +
                "    varsta INT,\n" +
                "    cnp VARCHAR(255),\n" +
                "    diagnostic_antecedent VARCHAR(255)\n" +
                ")";
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createMedsTable(){
        String query = "CREATE TABLE IF NOT EXISTS medicamente_men (\n" +
                "    id_pacient INT,\n" +
                "    nume_med VARCHAR(255),\n" +
                "    PRIMARY KEY (id_pacient, nume_med),\n"+
                "    FOREIGN KEY (id_pacient) REFERENCES pacienti_men(id) ON DELETE CASCADE"+

                ")";
        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAppointmentGPTable(){
        String query = "CREATE TABLE IF NOT EXISTS programari_med_primar (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    id_medic INT NOT NULL,\n" +
                "    id_pacient INT NOT NULL,\n" +
                "    data DATE,\n" +
                "    ora TIME,\n" +
                "    diagnostic VARCHAR(255),\n" +
                "    FOREIGN KEY (id_medic) REFERENCES medici_primari(id) ON DELETE CASCADE,"+
                "    FOREIGN KEY (id_pacient) REFERENCES pacienti_fiz(id) ON DELETE CASCADE"+
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAppointmentNurseTable(){
        String query = "CREATE TABLE IF NOT EXISTS programari_asist (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    id_medic INT NOT NULL,\n" +
                "    id_pacient INT NOT NULL,\n" +
                "    data DATE,\n" +
                "    ora TIME,\n" +
                "    diagnostic VARCHAR(255),\n" +
                "    FOREIGN KEY (id_medic) REFERENCES asistenti(id) ON DELETE CASCADE,"+
                "    FOREIGN KEY (id_pacient) REFERENCES pacienti_fiz(id) ON DELETE CASCADE"+
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAppointmentPsychTable(){
        String query = "CREATE TABLE IF NOT EXISTS programari_psih (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    id_medic INT NOT NULL,\n" +
                "    id_pacient INT NOT NULL,\n" +
                "    data DATE,\n" +
                "    ora TIME,\n" +
                "    diagnostic VARCHAR(255),\n" +
                "    FOREIGN KEY (id_medic) REFERENCES psihiatri(id) ON DELETE CASCADE,"+
                "    FOREIGN KEY (id_pacient) REFERENCES pacienti_men(id) ON DELETE CASCADE"+
                ")";

        try (Connection connection = DBConfig.getDatabaseConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
