package com.unibuc.services;

import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;
import com.unibuc.patient.Pacient;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;

public class Main {

    public static void main(String[] args) {
//        CadruMedical a = new Asistent("Ana Ionescu","Feminim","Bucuresti,Nucului nr.45",34,8000,2);
//        CadruMedical mp = new MedicPrimar("Anda Florea", "Feminim","Bucuresti, Pacii nr. 4", 43, 10000,"cardiologie", 3);
//        CadruMedical p = new Psihiatru("Mihail Banea","Masculin","Bucuresti, Aviatiei nr. 56", 46, 9500, 3);
//        Pacient pf = new PacientSanatateFizica("Andrei Sandulescu", "Masculin", "Bucuresti, Grigore Ureche nr. 32", "5001211220961", 31, "123321445");
//        Pacient pm = new PacientSanatateMentala("George Grigore", "Masculin", "Bucuresti, Carpatin nr.9", "5991019332567", 21, "autism", 0, new String[]{"-"});
////        System.out.print(a.calculateSalary());
//        System.out.println();
//        System.out.print(mp.calculateSalary());
//        System.out.println();
//        System.out.print(p.calculateSalary());

//        System.out.println(pm);
//        System.out.println(mp);
//        System.out.println(a);

        //a.showMedicalStaff();
        Service.addMedicalStaff();
        Service.addMedicalStaff();
        Service.addMedicalStaff();
        Service.showMedicalStaffList();
        Service.addPatient();
        Service.addPatient();
        Service.showPatients();
        Service.sortMedicalStaffByAgeAndName();
        Service.sortPatientsByAgeAndName();
        Service.showMedicalStaffList();
        Service.showMedicalStaffList();

    }
}
