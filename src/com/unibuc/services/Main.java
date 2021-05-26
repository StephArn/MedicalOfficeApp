package com.unibuc.services;

//import com.unibuc.io.ReadCSV;
//import com.unibuc.io.WriteCSV;
import com.unibuc.database.config.SetupData;
import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;
import com.unibuc.patient.Pacient;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
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
//        ServiceProgramare appointments = ServiceProgramare.getInstance();
//        ServiceMedic staff = ServiceMedic.getInstance();
//        ServicePacient patients = ServicePacient.getInstance();
//        staff.addMedicalStaff();
//        staff.addMedicalStaff();
//        staff.addMedicalStaff();
//        staff.showMedicalStaffList();
//        patients.addPatient();
//        patients.addPatient();
//        patients.showPatients();
//        staff.sortMedicalStaffByAgeAndName();
//        patients.sortPatientsByAgeAndName();
//        staff.showMedicalStaffList();
//        patients.showPatients();

//        ReadCSV in = ReadCSV.getInstance();
//        in.readGPFromCSV();
//        in.readNurseFromCSV();
//        in.readPsychFromCSV();
//        in.readPatientPhysicalFromCSV();
//        in.readPatientMentalFromCSV();
//
//        ServiceMedic med = ServiceMedic.getInstance();
//        ServicePacient pat = ServicePacient.getInstance();

//        med.showMedicalStaffList();
//        pat.showPatients();
//
//        ArrayList<CadruMedical> staff = med.getStaff();
//        ArrayList<Pacient> patients = pat.getPatients();
//
//        WriteCSV out = WriteCSV.getInstance();
//
//        for(var m : staff)
//        {
//            if (m instanceof MedicPrimar){
//                out.writeGPOnCSV((MedicPrimar) m);
//            }
//            else if(m instanceof Asistent){
//                out.writeNurseOnCSV((Asistent) m);
//            }
//            else if(m instanceof Psihiatru){
//                out.writePsychOnCSV((Psihiatru) m);
//            }
//        }
//
//        for(var m : patients)
//        {
//            if (m instanceof PacientSanatateFizica){
//                out.writePatientPhysicalOnCSV((PacientSanatateFizica) m);
//            }
//            else if(m instanceof PacientSanatateMentala){
//                out.writePatientMentalOnCSV((PacientSanatateMentala) m);
//            }
//
//        }
//
//        Asistent a = new Asistent("Ana S. Ionescu","F","4321 Maple Street",34,8000,2);
//        out.writeNurseOnCSV(a);
//        MedicPrimar mp = new MedicPrimar("Anda A. Florea", "F","1621 Pacii Street", 43, 10000,"cardiology", 3);
//        out.writeGPOnCSV(mp);
//        Psihiatru p = new Psihiatru("Mihail C. Banea","M","1313 Crescent Street", 46, 9000, 3);
//        out.writePsychOnCSV(p);
//
//        ServiceProgramare appointments = ServiceProgramare.getInstance();
//        appointments.addAppointment();

        SetupData setupData = new SetupData();
        setupData.setup();

        ServiceMedic serviceMedic = ServiceMedic.getInstance();
//        serviceMedic.addGPToDB();
//        serviceMedic.addNurseToDB();
//        serviceMedic.addPsychToDB();
//        System.out.println(serviceMedic.getGPsFromDB());
//        System.out.println(serviceMedic.getNursesFromDB());
//        System.out.println(serviceMedic.getPsychFromDB());

        //serviceMedic.changeGPAddress();
        ServicePacient servicePacient = ServicePacient.getInstance();
//        servicePacient.addPatientPhysicalToDB();
//        servicePacient.addPatientMentalToDB();
//        servicePacient.addPatientMentalToDB();

//        System.out.println(servicePacient.getPatPhysFromDB());
        //System.out.println(servicePacient.getPatMenFromDB());
        //servicePacient.removePatPhysFromDByID();
        //serviceMedic.removeGPFromDByID();
        //servicePacient.removePatMenFromDByID();
        servicePacient.changePatMenAddress();

    }
}
