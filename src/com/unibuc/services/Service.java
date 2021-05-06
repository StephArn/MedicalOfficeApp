package com.unibuc.services;

import com.unibuc.appointment.Programare;
import com.unibuc.medical_staff.*;
import com.unibuc.patient.*;
import com.unibuc.services.*;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;

public class Service {

    static ArrayList<CadruMedical> staff = new ArrayList<>();
    static ArrayList<Pacient> patients = new ArrayList<>();
//    static ArrayList<Asistent> nurses = new ArrayList<>();
//    static ArrayList<MedicPrimar> gp = new ArrayList<>();
//    static ArrayList<Psihiatru> psychiatrists = new ArrayList<>();
    //static ArrayList<Programare> appointments = new ArrayList<>();

//    public static CadruMedical searchStaffByID (int id) {
//        boolean found = false;
//        CadruMedical as = null;
//        for (CadruMedical asist:staff) {
//            if (asist.getIdMedic() == id) {
//                as = asist;
//                found = true;
//                break;
//            }
//        }
//        if (!found)
//            System.out.println("Niciun cadru medical cu acest ID!");
//        return as;
//    }

//    public static Pacient searchPatientByID (int id) {
//        boolean found = false;
//        Pacient as = null;
//        for (Pacient asist:patients) {
//            if (asist.getIdPacient() == id) {
//                as = asist;
//                found = true;
//                break;
//            }
//        }
//        if (!found)
//            System.out.println("Niciun pacient cu acest ID!");
//        return as;
//    }

//    public static Programare searchAppointmentByID (int id) {
//        boolean found = false;
//        Programare as = null;
//        for (Programare asist:appointments) {
//            if (asist.getIdProgramare() == id) {
//                as = asist;
//                found = true;
//                break;
//            }
//        }
//        if (!found)
//            System.out.println("Nicio programare cu acest ID!");
//        return as;
//    }

//    public static MedicPrimar searchGPByID (int id) {
//        boolean found = false;
//        MedicPrimar mp = null;
//        for (MedicPrimar med:gp) {
//            if (med.getIdMedic() == id) {
//                mp = med;
//                found = true;
//                break;
//            }
//        }
//        if (!found)
//            System.out.println("Niciun medic primar cu acest ID!");
//        return mp;
//    }
//
//    public static Psihiatru searchPsychiatristByID (int id) {
//        boolean found = false;
//        Psihiatru p = null;
//        for (Psihiatru psi:psychiatrists) {
//            if (psi.getIdMedic() == id) {
//                p = psi;
//                found = true;
//                break;
//            }
//        }
//        if (!found)
//            System.out.println("Niciun psihiatru cu acest ID!");
//        return p;
//    }
//
//    public static Client searchClient (int id) {
//        Client newClient = null;
//        for (Client client:clients) {
//            if (client.getClientId() == id) {
//                newClient = client;
//            }
//        }
//        return newClient;
//    }
//
//    public static void showMedicalStaffList() {
//        System.out.println("Current Medical Staff:");
//        for (var med: staff)
//            med.showMedicalStaff();
//    }


//    public static void showPatients() {
//        System.out.println("Current Patients:");
//        for (var pat: patients)
//            System.out.println(pat);
//    }

//    public static void addMedicalStaff() {
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.println("Personal data:");
//        System.out.print("Name: ");
//        String name = scanner.next();
//        System.out.print("Gender: ");
//        String gender = scanner.next();
//        System.out.print("Address: ");
//        String address = scanner.next();
//        System.out.print("Age: ");
//        int age = scanner.nextInt();
//        System.out.print("Base Salary: ");
//        double baseSalary = scanner.nextDouble();
//        System.out.print("What type of medical staff are they? Type 1 for Nurse, 2 for GP or 3 for Psychiatrist.");
//        int type = scanner.nextInt();
//        switch (type){
//            case 1:
//                System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
//                int lvl = scanner.nextInt();
//                CadruMedical nurse = new Asistent(name, gender, address, age, baseSalary, lvl);
//                staff.add(nurse);
//                System.out.println("Success!");
//                //System.out.println(nurse);
//                break;
//            case 2:
//                System.out.print("What is their specialisation?");
//                String specialisation = scanner.next();
//                System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
//                int lvlgp = scanner.nextInt();
//                CadruMedical gp = new MedicPrimar(name, gender, address, age, baseSalary,specialisation, lvlgp);
//                staff.add(gp);
//                System.out.println("Success!");
//                //System.out.println(gp);
//                break;
//            case 3:
//                System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
//                int lvlp = scanner.nextInt();
//                CadruMedical psychiatrist = new Psihiatru(name, gender, address, age, baseSalary, lvlp);
//                staff.add(psychiatrist);
//                System.out.println("Success!");
//                //System.out.println(psychiatrist);
//                break;
//            default:
//                System.out.println("Invalid operation. Try again!");
//        }
//    }
//
//    public static void addPatient(){
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.println("Personal data");
//        System.out.print("Name: ");
//        String name = scanner.next();
//        System.out.print("Gender: ");
//        String gender= scanner.next();
//        System.out.print("Address: ");
//        String address= scanner.next();
//        System.out.print("ID Card Number: ");
//        String idCard = scanner.next();
//        System.out.print("Age: ");
//        int age = scanner.nextInt();
//        System.out.print("Are they here for their Physical or Mental Health? Type 1 for Physical or 2 for Mental");
//        int type = scanner.nextInt();
//        switch (type){
//            case 1:
//                System.out.print("Insurance Number: ");
//                String insurance = scanner.next();
//                Pacient fiz = new PacientSanatateFizica(name, gender, address, idCard, age, insurance);
//                patients.add(fiz);
//                System.out.println("Success!");
//                break;
//            case 2:
//                System.out.print("What is their previous diagnostic?");
//                String prev = scanner.next();
//                System.out.print("How many medications do they take? If none, type 0.");
//                int nrmeds = scanner.nextInt();
//                String[] meds;
//                if(nrmeds != 0){
//                    System.out.print("State the names of the medications one by one: ");
//                    meds = new String[nrmeds];
//                    for(int i = 0; i < nrmeds; i++){
//                        meds[i] = scanner.next();
//                    }
//                }
//                else{
//                    meds = new String[]{"-"};
//                }
//                Pacient men = new PacientSanatateMentala(name, gender, address, idCard, age, prev, nrmeds, meds);
//                patients.add(men);
//                System.out.println("Success!");
//                //System.out.println(gp);
//                break;
//            default:
//                System.out.println("Invalid operation. Try again!");
//                return;
//        }
//
//    }

//    public static void removeMedicalStaffByID() {
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.print("Type ID for the staff member you want to remove:");
//        int del = scanner.nextInt();
//        CadruMedical med = searchStaffByID(del);
//        if (med == null)
//            return;
//        staff.remove(med);
//    }

//    public void removePatientByID() {
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.print("Type ID for the patient you want to remove:");
//        int del = scanner.nextInt();
//        Pacient med = searchPatientByID(del);
//        if (med == null)
//            return;
//        patients.remove(med);
//    }

//    public static void sortMedicalStaffByAgeAndName()
//    {
//        Collections.sort(staff, new ComparatorStaffAge());
//        Collections.sort(staff, new ComparatorStaffName());
//        System.out.println("Sorted! Display the medical staff list to see the changes.\n");
//    }


//    public void sortPatientsByAgeAndName()
//    {
//        Collections.sort(patients, new ComparatorPatientAge());
//        Collections.sort(patients, new ComparatorPatientName());
//        System.out.println("Sorted! Display the patients list to see the changes.\n");
//    }

//    public void addAppointment() throws ParseException {
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.println("Data for the appointment: \n");
//        System.out.println("Patient's ID: ");
//        int id = scanner.nextInt();
//        System.out.println("Patient's Diagnostic: ");
//        String diag = scanner.next();
//        System.out.println("What is the service needed? Type 1 for Routine Checkup / Prescription Renewal , 2 for Physical Examination or 3 for Mental Examination.\n");
//        int type = scanner.nextInt();
//        Pacient p = searchPatientByID(id);
//        CadruMedical app;
//        switch (type){
//            case 1:
//                System.out.println("For Routine Checkup / Prescription Renewal, there is a Nurse needed. Please look through the list of staff and type the ID of the Nurse you would like.\n");
//                showMedicalStaffList();
//                int idn = scanner.nextInt();
//                while (!(searchStaffByID(idn) instanceof  Asistent)) {
//                    System.out.println("Sorry, that's not a valid ID.");
//                    idn = scanner.nextInt();
//                }
//                app = searchStaffByID(idn);
//                break;
//            case 2:
//                System.out.println("For Physical Examination, there is a GP needed. Please look through the list of staff and type the ID of the GP you would like.\n");
//                showMedicalStaffList();
//                int idf = scanner.nextInt();
//                while (!(searchStaffByID(idf) instanceof  MedicPrimar)) {
//                    System.out.println("Sorry, that's not a valid ID.");
//                    idn = scanner.nextInt();
//                }
//                app = searchStaffByID(idf);
//                break;
//            case 3:
//                System.out.println("For Mental Examination, there is a Psychiatrist needed. Please look through the list of staff and type the ID of the Psychiatrist you would like.\n");
//                showMedicalStaffList();
//                int idp = scanner.nextInt();
//                while (!(searchStaffByID(idp) instanceof  MedicPrimar)) {
//                    System.out.println("Sorry, that's not a valid ID.");
//                    idn = scanner.nextInt();
//                }
//                app = searchStaffByID(idp);
//                break;
//
//            default:
//                app = null;
//                System.out.println("Invalid operation. Try again!");
//                return;
//        }
//
//        System.out.println("Date (Format as dd/mm/yyyy) : ");
//        String date1 = scanner.next();
//        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
//        System.out.println("Time (Format as hh/mm/ss) : ");
//        String time1 = scanner.next();
//        LocalTime time = LocalTime.parse(time1, DateTimeFormatter.ofPattern("HH'h 'mm'm 'ss's'"));
//        Programare prog = new Programare(app,p,diag,date,time);
//        appointments.add(prog);
//
//        System.out.println("Success!");
//    }

//    public static void removeAppointmentByID() {
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.print("Type ID for the appointment you want to remove:");
//        int del = scanner.nextInt();
//        Programare med = searchAppointmentByID(del);
//        if (med == null)
//            return;
//        appointments.remove(med);
//    }

}
