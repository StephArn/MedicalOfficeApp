package com.unibuc.medical_staff;

import com.unibuc.Persoana;

public abstract class CadruMedical extends Persoana {

    protected String name;
    protected String gender;
    protected String address;
    protected int age;
    protected int idMedic;
    static int idIncrement = 0;
    protected double baseSalary;

    {
        this.idMedic = ++idIncrement;
    }

    public CadruMedical(String n, String g, String add, int a, double base_salary)
    {
        super(n,g,add,a);
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public abstract void showMedicalStaff();

    public int getIdMedic() {
        return idMedic;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public double getBaseSalary() {
//        return baseSalary;
//    }
//
//    public void setBaseSalary(double baseSalary) {
//        this.baseSalary = baseSalary;
//    }
}
