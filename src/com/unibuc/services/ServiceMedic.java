package com.unibuc.services;

import com.unibuc.database.repository.RepoMedic;
import com.unibuc.io.WriteCSV;
import com.unibuc.medical_staff.*;
import com.unibuc.patient.PacientSanatateFizica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ServiceMedic {

    static RepoMedic repoMedic = new RepoMedic();

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

    public List<MedicPrimar> getGPsFromDB() {
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return GPs from DB");
        return repoMedic.findAllGPs();
    }

    public List<Asistent> getNursesFromDB() {
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return Nurses from DB");
        return repoMedic.findAllNurses();
    }

    public List<Psihiatru> getPsychFromDB() {
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return Psychs from DB");
        return repoMedic.findAllPsych();
    }

    public MedicPrimar getGPFromDBById(int id){
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return GP by Id from DB");
        return repoMedic.findGPById(id);
    }

    public Asistent getNurseFromDBById(int id){
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return Nurse by Id from DB");
        return repoMedic.findNurseById(id);
    }

    public Psihiatru getPsychFromDBById(int id){
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Return Psych by Id from DB");
        return repoMedic.findPsychById(id);
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

    public void addGPToDB() {
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
        System.out.print("What is their specialisation?");
        String specialisation = scanner.next();
        System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
        int lvlgp = scanner.nextInt();
        MedicPrimar gp = new MedicPrimar(name, gender, address, age, baseSalary,specialisation, lvlgp);
        repoMedic.saveGP(gp);
        //CadruMedical gp1 = new MedicPrimar(name, gender, address, age, baseSalary,specialisation, lvlgp);
        staff.add(gp);
        System.out.println("Success!");
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Add GB to DB");
    }

    public void addNurseToDB() {
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
        System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
        int lvl = scanner.nextInt();
        Asistent nurse = new Asistent(name, gender, address, age, baseSalary, lvl);
        repoMedic.saveNurse(nurse);
        staff.add(nurse);
        System.out.println("Success!");

        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Add Nurse to DB");
    }

    public void addPsychToDB() {
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
        System.out.print("What is their experience level? Type 0 for under 5 years of experience, 1 for 5-9 years, 2 for 10-14, or 3 for 15+.");
        int lvlp = scanner.nextInt();
        Psihiatru psychiatrist = new Psihiatru(name, gender, address, age, baseSalary, lvlp);
        repoMedic.savePsych(psychiatrist);
        staff.add(psychiatrist);
        System.out.println("Success!");

        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Add Psych to DB");
    }

    public void removeGPFromDByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the GP you want to remove:");
        int del = scanner.nextInt();
        MedicPrimar med = repoMedic.findGPById(del);
        if (med == null) {
            System.out.println("That isn't a valid ID");
            return;
        }
        repoMedic.deleteGPById(del);
        staff.remove(med);
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Remove GP from DB by ID");
    }

    public void removeNurseFromDByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the nurse you want to remove:");
        int del = scanner.nextInt();
        Asistent med = repoMedic.findNurseById(del);
        if (med == null) {
            System.out.println("That isn't a valid ID");
            return;
        }
        staff.remove(med);
        repoMedic.deleteNurseById(del);
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Remove nurse from DB by ID");
    }

    public void removePsychFromDByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the psychiatrist you want to remove: ");
        int del = scanner.nextInt();
        Psihiatru med = repoMedic.findPsychById(del);
        if (med == null) {
            System.out.println("That isn't a valid ID");
            return;
        }
        staff.remove(med);
        repoMedic.deletePsychById(del);
        WriteCSV out = WriteCSV.getInstance();
        out.writeAudit("Remove psych from DB by ID");
    }

    public void changeGPAddress() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Type the ID of the GP whose address you want to change: ");
        int id = scanner.nextInt();
        System.out.println("Type the new address: ");
        String newAddress = scanner.next();
        if(repoMedic.updateGP(id,newAddress))
            System.out.println("Success!");
        else
            System.out.println("Couldn't change the address...");
    }

    public void changeNurseAddress() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Type the ID of the nurse whose address you want to change: ");
        int id = scanner.nextInt();
        System.out.println("Type the new address: ");
        String newAddress = scanner.next();
        if(repoMedic.updateNurse(id,newAddress))
            System.out.println("Success!");
        else
            System.out.println("Couldn't change the address...");
    }

    public void changePsychAddress() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Type the ID of the psychiatrist whose address you want to change: ");
        int id = scanner.nextInt();
        System.out.println("Type the new address: ");
        String newAddress = scanner.next();
        if(repoMedic.updatePsych(id,newAddress))
            System.out.println("Success!");
        else
            System.out.println("Couldn't change the address...");
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
