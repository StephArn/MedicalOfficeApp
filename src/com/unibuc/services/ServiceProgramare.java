package com.unibuc.services;

import com.unibuc.appointment.*;
import com.unibuc.io.WriteCSV;
import com.unibuc.medical_staff.*;
import com.unibuc.patient.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class ServiceProgramare {

    private ArrayList<Programare> appointments;
    private static ServiceProgramare instance = null;

    private ServiceProgramare() {
        appointments = new ArrayList<>();
    }

    public static ServiceProgramare getInstance() {
        if(instance == null) {
            instance = new ServiceProgramare();
        }
        return instance;
    }

    public Programare searchAppointmentByID (int id) {
        boolean found = false;
        Programare as = null;
        for (Programare asist:appointments) {
            if (asist.getIdProgramare() == id) {
                as = asist;
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Nicio programare cu acest ID!");
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return Appointments");
        return as;
    }

    public void addAppointment() throws ParseException {
        ServiceMedic staff = ServiceMedic.getInstance();
        ServicePacient patients = ServicePacient.getInstance();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Data for the appointment: \n");
        System.out.println("Patient's ID: ");
        int id = scanner.nextInt();
        System.out.println("Patient's Diagnostic: ");
        String diag = scanner.next();
        System.out.println("What is the service needed? Type 1 for Routine Checkup / Prescription Renewal , 2 for Physical Examination or 3 for Mental Examination.\n");
        int type = scanner.nextInt();
        Pacient p = patients.searchPatientByID(id);
        CadruMedical app;
        switch (type){
            case 1:
                System.out.println("For Routine Checkup / Prescription Renewal, there is a Nurse needed. Please look through the list of staff and type the ID of the Nurse you would like.\n");
                staff.showMedicalStaffList();
                int idn = scanner.nextInt();
                while (!(staff.searchStaffByID(idn) instanceof Asistent)) {
                    System.out.println("Sorry, that's not a valid ID.");
                    idn = scanner.nextInt();
                }
                app = staff.searchStaffByID(idn);
                break;
            case 2:
                System.out.println("For Physical Examination, there is a GP needed. Please look through the list of staff and type the ID of the GP you would like.\n");
                staff.showMedicalStaffList();
                int idf = scanner.nextInt();
                while (!(staff.searchStaffByID(idf) instanceof MedicPrimar)) {
                    System.out.println("Sorry, that's not a valid ID.");
                    idn = scanner.nextInt();
                }
                app = staff.searchStaffByID(idf);
                break;
            case 3:
                System.out.println("For Mental Examination, there is a Psychiatrist needed. Please look through the list of staff and type the ID of the Psychiatrist you would like.\n");
                staff.showMedicalStaffList();
                int idp = scanner.nextInt();
                while (!(staff.searchStaffByID(idp) instanceof  MedicPrimar)) {
                    System.out.println("Sorry, that's not a valid ID.");
                    idn = scanner.nextInt();
                }
                app = staff.searchStaffByID(idp);
                break;

            default:
                app = null;
                System.out.println("Invalid operation. Try again!");
                return;
        }

        System.out.println("Date (Format as dd/mm/yyyy) : ");
        String date1 = scanner.next();
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
        System.out.println("Time (Format as hh/mm/ss) : ");
        String time1 = scanner.next();
        LocalTime time = LocalTime.parse(time1, DateTimeFormatter.ofPattern("HH'h 'mm'm 'ss's'"));
        Programare prog = new Programare(app,p,diag,date,time);
        appointments.add(prog);

        System.out.println("Success!");
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Add Appointment on Console");
    }

    public void removeAppointmentByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the appointment you want to remove:");
        int del = scanner.nextInt();
        Programare med = searchAppointmentByID(del);
        if (med == null)
            return;
        appointments.remove(med);
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Remove Appointment by ID");
    }



}
