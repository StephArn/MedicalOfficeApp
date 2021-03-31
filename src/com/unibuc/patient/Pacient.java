package com.unibuc.patient;

public abstract class Pacient {
    protected String name;
    protected String gender;
    protected String address;
    protected String idCard;
    protected int age;
    protected int idPacient;
    static int idIncrement = 0;

    {
        this.idPacient = ++idIncrement;
    }

    public Pacient(String name, String gender, String address, String idCard, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.idCard = idCard;
        this.age = age;
    }

    //public abstract void showPatient();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdPacient() {
        return idPacient;
    }
}
