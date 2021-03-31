package com.unibuc.medical_staff;

public abstract class CadruMedical {

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
        this.name = n;
        this.gender = g;
        this.address = add;
        this.age = a;
        this.baseSalary = base_salary;
    }

    public abstract double calculateSalary();

    public abstract void showMedicalStaff();

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
