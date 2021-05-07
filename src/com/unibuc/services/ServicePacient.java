package com.unibuc.services;

import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.patient.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ServicePacient {

    private ArrayList<Pacient> patients;
    private static ServicePacient instance = null;

    private ServicePacient() {
        patients = new ArrayList<>();
    }

    public static ServicePacient getInstance() {
        if(instance == null) {
            instance = new ServicePacient();
        }
        return instance;
    }

    public Pacient searchPatientByID (int id) {
        boolean found = false;
        Pacient as = null;
        for (Pacient asist:patients) {
            if (asist.getIdPacient() == id) {
                as = asist;
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Niciun pacient cu acest ID!");
        return as;
    }
    public void showPatients() {
        System.out.println("Current Patients:");
        for (var pat: patients)
            System.out.println(pat);
    }


    public void addPatient(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Personal data");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Gender: ");
        String gender= scanner.next();
        System.out.print("Address: ");
        String address= scanner.next();
        System.out.print("ID Card Number: ");
        String idCard = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Are they here for their Physical or Mental Health? Type 1 for Physical or 2 for Mental");
        int type = scanner.nextInt();
        switch (type){
            case 1:
                System.out.print("Insurance Number: ");
                String insurance = scanner.next();
                Pacient fiz = new PacientSanatateFizica(name, gender, address, idCard, age, insurance);
                patients.add(fiz);
                System.out.println("Success!");
                break;
            case 2:
                System.out.print("What is their previous diagnostic?");
                String prev = scanner.next();
                System.out.print("How many medications do they take? If none, type 0.");
                int nrmeds = scanner.nextInt();
                String[] meds;
                if(nrmeds != 0){
                    System.out.print("State the names of the medications one by one: ");
                    meds = new String[nrmeds];
                    for(int i = 0; i < nrmeds; i++){
                        meds[i] = scanner.next();
                    }
                }
                else{
                    meds = new String[]{"-"};
                }
                Pacient men = new PacientSanatateMentala(name, gender, address, idCard, age, prev, nrmeds, meds);
                patients.add(men);
                System.out.println("Success!");
                //System.out.println(gp);
                break;
            default:
                System.out.println("Invalid operation. Try again!");
                return;
        }

    }

    public void removePatientByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the patient you want to remove:");
        int del = scanner.nextInt();
        Pacient med = searchPatientByID(del);
        if (med == null)
            return;
        patients.remove(med);
    }

    public void sortPatientsByAgeAndName()
    {
        Collections.sort(patients, new ComparatorPatientAge());
        Collections.sort(patients, new ComparatorPatientName());
        System.out.println("Sorted! Display the patients list to see the changes.\n");
    }


    public void addPatientFromCSV(Pacient p) {
        boolean already = false;
        for (Pacient a : patients)
            if (a.equals(p)) {
                already = true;
                break;
            }
        if (!already) {
            patients.add(p);
        }
    }
}
