package com.unibuc.io;

import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;
import com.unibuc.patient.PacientSanatateFizica;
import com.unibuc.patient.PacientSanatateMentala;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    private static WriteCSV instance = null;

    public static WriteCSV getInstance() {
        if (instance == null)
            instance = new WriteCSV();
        return instance;
    }


    public void writeGPOnCSV(MedicPrimar med) {
        try (var out = new BufferedWriter(new FileWriter("src/com/unibuc/io/med_primar_write.csv",true))) {
            out.write(med.getIdMedic() + ", " + med.getName() + ", " + med.getGender() + ", " + med.getAddress() + ", " + med.getAge() +  ", " + med.getspecialisation() + ", " + med.calculateSalary() + '\n');
        } catch (IOException e) {
            System.out.println("Writing Exception: "+ e.getMessage());
        }
    }

    public void writeNurseOnCSV(Asistent med) {
        try (var out = new BufferedWriter(new FileWriter("src/com/unibuc/io/asist_write.csv",true))) {
            out.write(med.getIdMedic() + ", " + med.getName() + ", " + med.getGender() + ", " + med.getAddress() + ", " + med.getAge() + ", " + med.calculateSalary() + '\n');
        } catch (IOException e) {
            System.out.println("Writing Exception: "+ e.getMessage());
        }
    }

    public void writePsychOnCSV(Psihiatru med) {
        try (var out = new BufferedWriter(new FileWriter("src/com/unibuc/io/psih_write.csv",true))) {
            out.write(med.getIdMedic() + ", " + med.getName() + ", " + med.getGender() + ", " + med.getAddress() + ", " + med.getAge() + ", " + med.calculateSalary() + '\n');
        } catch (IOException e) {
            System.out.println("Writing Exception: "+ e.getMessage());
        }
    }

    public void writePatientPhysicalOnCSV(PacientSanatateFizica pat) {
        try (var out = new BufferedWriter(new FileWriter("src/com/unibuc/io/pac_fiz_write.csv",true))) {
            out.write(pat.getIdPacient() + ", " + pat.getName() + ", " + pat.getGender() + ", " + pat.getAddress() + ", " + pat.getAge() + ", " + pat.getIdCard()+ ", " + pat.getInsuranceID() + '\n');
        } catch (IOException e) {
            System.out.println("Writing Exception: "+ e.getMessage());
        }
    }

    public void writePatientMentalOnCSV(PacientSanatateMentala pat) {
        try (var out = new BufferedWriter(new FileWriter("src/com/unibuc/io/pac_men_write.csv",true))) {
            out.write(pat.getIdPacient() + ", " + pat.getName() + ", " + pat.getGender() + ", " + pat.getAddress() + ", " + pat.getAge() + ", " + pat.getIdCard()+ ", " + pat.getPreviousDiagnostic()+ ", " + pat.getMedication() + '\n');
        } catch (IOException e) {
            System.out.println("Writing Exception: "+ e.getMessage());
        }
    }

}


