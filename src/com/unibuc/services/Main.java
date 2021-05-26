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
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
//        CadruMedical a = new Asistent("Ana Ionescu","Feminim","Bucuresti,Nucului nr.45",34,8000,2);
//        CadruMedical mp = new MedicPrimar("Anda Florea", "Feminim","Bucuresti, Pacii nr. 4", 43, 10000,"cardiologie", 3);
//        CadruMedical p = new Psihiatru("Mihail Banea","Masculin","Bucuresti, Aviatiei nr. 56", 46, 9500, 3);
//        Pacient pf = new PacientSanatateFizica("Andrei Sandulescu", "Masculin", "Bucuresti, Grigore Ureche nr. 32", "5001211220961", 31, "123321445");
//        Pacient pm = new PacientSanatateMentala("George Grigore", "Masculin", "Bucuresti, Carpatin nr.9", "5991019332567", 21, "autism", 0, new String[]{"-"});

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
        ServiceProgramare serviceProgramare = ServiceProgramare.getInstance();
        ServicePacient servicePacient = ServicePacient.getInstance();

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        while (i != 0)
        {
            switch (i) {
                case 1:
                    serviceMedic.addGPToDB();
                    break;
                case 2:
                    serviceMedic.addNurseToDB();
                    break;
                case 3:
                    serviceMedic.addPsychToDB();
                    break;
                case 4:
                    servicePacient.addPatientPhysicalToDB();
                    break;
                case 5:
                    servicePacient.addPatientMentalToDB();
                    break;
                case 6:
                    serviceProgramare.addAppointmentGP();
                    break;
                case 7:
                    serviceProgramare.addAppointmentNurse();
                    break;
                case 8:
                    serviceProgramare.addAppointmentPsych();
                    break;
                case 9:
                    System.out.println(serviceMedic.getGPsFromDB());
                    break;
                case 10:
                    System.out.println(serviceMedic.getNursesFromDB());
                    break;
                case 11:
                    System.out.println(serviceMedic.getPsychFromDB());
                    break;
                case 12:
                    serviceMedic.removeGPFromDByID();
                    break;
                case 13:
                    serviceMedic.removeNurseFromDByID();
                    break;
                case 14:
                    serviceMedic.removePsychFromDByID();
                    break;
                case 15:
                    serviceMedic.changeGPAddress();
                    break;
                case 16:
                    serviceMedic.changeNurseAddress();
                    break;
                case 17:
                    serviceMedic.changePsychAddress();
                    break;
                case 18:
                    System.out.println(servicePacient.getPatPhysFromDB());
                    break;
                case 19:
                    System.out.println(servicePacient.getPatMenFromDB());
                    break;
                case 20:
                    servicePacient.removePatPhysFromDByID();
                    break;
                case 21:
                    servicePacient.removePatMenFromDByID();
                    break;
                case 22:
                    servicePacient.changePatPhysAddress();
                    break;
                case 23:
                    servicePacient.changePatMenAddress();


            }

            System.out.print("Command:");
            i = in.nextInt();
        }
    }

}
