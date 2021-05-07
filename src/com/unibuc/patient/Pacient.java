package com.unibuc.patient;

import com.unibuc.Persoana;

public abstract class Pacient extends Persoana {

    protected String idCard;
    protected int idPacient;
    static int idIncrement = 0;

    {
        this.idPacient = ++idIncrement;
    }

    public Pacient(String name, String gender, String address, String idCard, int age) {
        super(name,gender,address,age);
        this.idCard = idCard;
    }

    public int getIdPacient() {
        return idPacient;
    }

    //public abstract void showPatient();

//    public void setName(String name) {
//        this.name = name;
//    }
//
    public String getGender() {
        return gender;
    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public String getAddress() {
        return address;
    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getIdCard() {
        return idCard;
    }
//
//    public void setIdCard(String idCard) {
//        this.idCard = idCard;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
