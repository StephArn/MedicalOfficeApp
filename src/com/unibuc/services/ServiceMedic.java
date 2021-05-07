package com.unibuc.services;

import com.unibuc.io.WriteCSV;
import com.unibuc.medical_staff.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ServiceMedic {

    private ArrayList<CadruMedical> staff;
    private static ServiceMedic instance = null;

    private ServiceMedic() {
        staff = new ArrayList<>();
    }

    public static ServiceMedic getInstance() {
        if(instance == null) {
            instance = new ServiceMedic();
        }
        return instance;
    }

    public ArrayList<CadruMedical> getStaff() {
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return Staff");
        return staff;
    }

    public CadruMedical searchStaffByID (int id) {
        boolean found = false;
        CadruMedical as = null;
        for (CadruMedical asist:staff) {
            if (asist.getIdMedic() == id) {
                as = asist;
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Niciun cadru medical cu acest ID!");
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Search Staff by ID");
        return as;
    }

    public void showMedicalStaffList() {
        System.out.println("Current Medical Staff:");
        for (var med: staff)
            med.showMedicalStaff();
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Show Staff");
    }

    public void addMedicalStaff() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Personal data:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Gender: ");
        String gender = scanner.next();
        System.out.print("Address: ");
        String address = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Base Salary: ");
        double baseSalary = scanner.nextDouble();
        System.out.print("What type of medical staff are they? Type 1 for Nurse, 2 for GP or 3 for Psychiatrist.");
        int type = scanner.nextInt();
        switch (type){
            case 1:
                System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
                int lvl = scanner.nextInt();
                CadruMedical nurse = new Asistent(name, gender, address, age, baseSalary, lvl);
                staff.add(nurse);
                System.out.println("Success!");
                //System.out.println(nurse);
                break;
            case 2:
                System.out.print("What is their specialisation?");
                String specialisation = scanner.next();
                System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
                int lvlgp = scanner.nextInt();
                CadruMedical gp = new MedicPrimar(name, gender, address, age, baseSalary,specialisation, lvlgp);
                staff.add(gp);
                System.out.println("Success!");
                //System.out.println(gp);
                break;
            case 3:
                System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
                int lvlp = scanner.nextInt();
                CadruMedical psychiatrist = new Psihiatru(name, gender, address, age, baseSalary, lvlp);
                staff.add(psychiatrist);
                System.out.println("Success!");
                //System.out.println(psychiatrist);
                break;
            default:
                System.out.println("Invalid operation. Try again!");
        }
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Add Staff on Console");
    }

    public void removeMedicalStaffByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the staff member you want to remove:");
        int del = scanner.nextInt();
        CadruMedical med = searchStaffByID(del);
        if (med == null)
            return;
        staff.remove(med);
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Remove Staff by ID");
    }

    public void sortMedicalStaffByAgeAndName()
    {
        Collections.sort(staff, new ComparatorStaffAge());
        Collections.sort(staff, new ComparatorStaffName());
        System.out.println("Sorted! Display the medical staff list to see the changes.\n");
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Sort Staff");
    }


    public void addMedicalStaffFromCSV(CadruMedical med) {
        boolean already = false;
        for (CadruMedical a : staff)
            if (a.equals(med)) {
                already = true;
                break;
            }
        if (!already) {
            staff.add(med);
        }
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Add Staff from CSV");
    }
}
