package com.unibuc.patient;

public class PacientSanatateMentala extends Pacient{

    private String previousDiagnostic;
    private int nrOfMeds;
    private String[] medication = new String[nrOfMeds];
    public PacientSanatateMentala(String name, String gender, String address, String idCard, int age, String diag, int noMeds, String[] meds) {
        super(name, gender, address, idCard, age);
        this.previousDiagnostic = diag;
        this.nrOfMeds = noMeds;
        this.medication = meds;
    }

    public String getPreviousDiagnostic() {
        return previousDiagnostic;
    }

    public void setPreviousDiagnostic(String previousDiagnostic) {
        this.previousDiagnostic = previousDiagnostic;
    }

    public int getNoOfMeds() {
        return nrOfMeds;
    }

    public void setNoOfMeds(int noOfMeds) {
        this.nrOfMeds = noOfMeds;
    }

    public String[] getMedication() {
        return medication;
    }

    public void setMedication(String[] medication) {
        this.medication = medication;
    }
}
