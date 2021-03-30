package com.unibuc.patient;

public class PacientSanatateMentala extends Pacient{

    private String previousDiagnostic;
    private int noOfMeds;
    private String[] medication = new String[noOfMeds];
    public PacientSanatateMentala(String name, String gender, String address, String idCard, int age, String diag, int noMeds, String[] meds) {
        super(name, gender, address, idCard, age);
        this.previousDiagnostic = diag;
        this.noOfMeds = noMeds;
        this.medication = meds;
    }

    public String getPreviousDiagnostic() {
        return previousDiagnostic;
    }

    public void setPreviousDiagnostic(String previousDiagnostic) {
        this.previousDiagnostic = previousDiagnostic;
    }

    public int getNoOfMeds() {
        return noOfMeds;
    }

    public void setNoOfMeds(int noOfMeds) {
        this.noOfMeds = noOfMeds;
    }

    public String[] getMedication() {
        return medication;
    }

    public void setMedication(String[] medication) {
        this.medication = medication;
    }
}
