package com.unibuc.io;

import com.unibuc.appointment.Programare;
import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;
import com.unibuc.services.ServiceMedic;
import com.unibuc.services.ServicePacient;
import com.unibuc.services.ServiceProgramare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

public class ReadCSV {
    private static ReadCSV instance = null;

    private ReadCSV() {
    }

    public static ReadCSV getInstance() {
        if (instance == null)
            instance = new ReadCSV();
        return instance;
    }

    public void readGPFromCSV() {
        try(var in = new BufferedReader(new FileReader("src/com/unibuc/io/med_primar.csv"))){
            String line;
            ServiceMedic med = ServiceMedic.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.split(",");
                med.addMedicalStaffFromCSV(new MedicPrimar(fields[0], fields[1], fields[2],Integer.parseInt(fields[3]), Double.parseDouble(fields[4]), fields[5], Integer.parseInt(fields[6])));
            }
            //med.showMedicalStaffList();
        } catch (IOException e) {
            System.out.println("Reading Exception GP: "+ e.getMessage());
        }
    }


    public void readNurseFromCSV() {
        try(var in = new BufferedReader(new FileReader("src/com/unibuc/io/asist.csv"))){
            String line;
            ServiceMedic med = ServiceMedic.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.split(",");
                med.addMedicalStaffFromCSV(new Asistent(fields[0], fields[1], fields[2],Integer.parseInt(fields[3]), Double.parseDouble(fields[4]), Integer.parseInt(fields[5])));
            }
            //med.showMedicalStaffList();
        } catch (IOException e) {
            System.out.println("Reading Exception Nurse: "+ e.getMessage());
        }
    }

    public void readPsychFromCSV() {
        try(var in = new BufferedReader(new FileReader("src/com/unibuc/io/psih.csv"))){
            String line;
            ServiceMedic med = ServiceMedic.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.split(",");
                med.addMedicalStaffFromCSV(new Psihiatru(fields[0], fields[1], fields[2],Integer.parseInt(fields[3]), Double.parseDouble(fields[4]), Integer.parseInt(fields[5])));
            }
            //med.showMedicalStaffList();
        } catch (IOException e) {
            System.out.println("Reading Exception Psychiatrist: "+ e.getMessage());
        }
    }

    public void readPatientPhysicalFromCSV() {
        try(var in = new BufferedReader(new FileReader("src/com/unibuc/io/pac_fiz.csv"))){
            String line;
            ServicePacient pat = ServicePacient.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.split(",");
                pat.addPatientFromCSV(new PacientSanatateFizica(fields[0], fields[1], fields[2],fields[3], Integer.parseInt(fields[4]), fields[5]));
            }
            //System.out.println();
            //pat.showPatients();
        } catch (IOException e) {
            System.out.println("Reading Exception Physical Patient: "+ e.getMessage());
        }
    }

    public void readPatientMentalFromCSV() {
        try(var in = new BufferedReader(new FileReader("src/com/unibuc/io/pac_men.csv"))){
            String line;
            ServicePacient pat = ServicePacient.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.split(",");
                pat.addPatientFromCSV(new PacientSanatateMentala(fields[0], fields[1], fields[2],fields[3], Integer.parseInt(fields[4]), fields[5], Integer.parseInt(fields[6]), new Vector<String>(Arrays.asList(fields[7].split(";")))));
            }
            //pat.showPatients();
        } catch (IOException e) {
            System.out.println("Reading Exception Mental Patient: "+ e.getMessage());
        }
    }

    public void readAppFromCSV() {
        try(var in = new BufferedReader(new FileReader("src/com/unibuc/io/app.csv"))){
            String line;
            ServiceProgramare prog = ServiceProgramare.getInstance();
            ServiceMedic med = ServiceMedic.getInstance();
            ServicePacient pat = ServicePacient.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.split(",");
                prog.addAppointmentFromCSV(new Programare(med.searchStaffByID(Integer.parseInt(fields[0])), pat.searchPatientByID(Integer.parseInt(fields[1])),fields[2], Date.from(Instant.parse(fields[3])), LocalTime.parse(fields[4])));
            }
        } catch (IOException e) {
            System.out.println("Reading Exception Mental Patient: "+ e.getMessage());
        }
    }


}
