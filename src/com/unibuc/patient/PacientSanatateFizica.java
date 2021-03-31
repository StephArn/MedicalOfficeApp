package com.unibuc.patient;

public class PacientSanatateFizica extends Pacient{

    private String insuranceID;

    public PacientSanatateFizica(String name, String gender, String address, String idCard, int age, String iId) {
        super(name, gender, address, idCard, age);
        this.insuranceID = iId;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    @Override
    public String toString() {
        return "Pacient Sectia Sanatate Fizica \n" +
                " ID: " + idPacient + '\n' +
                " Nume: " + name + '\n' +
                " Gen: " + gender + '\n' +
                " Adresa: " + address + '\n' +
                " Varsta: " + age + '\n' +
                " CNP: " + idCard + '\n' +
                " Card de Sanatate: " + insuranceID + '\n' +
                "----------\n";
    }
}
