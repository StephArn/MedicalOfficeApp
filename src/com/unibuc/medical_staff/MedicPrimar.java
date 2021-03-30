package com.unibuc.medical_staff;

public class MedicPrimar extends CadruMedical{
    private String specialty;
    private int experienceLevel;
    static final double[] payBonus = {5, 10, 15, 20};

    public MedicPrimar(String n, String g, String add, int a, double base_salary, String specialty, int el) {
        super(n, g, add, a, base_salary);
        this.specialty = specialty;
        this.experienceLevel = el;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + baseSalary * payBonus[experienceLevel]/100;
    }

    @Override
    public String toString() {
        return "Medic Primar \n" +
                " ID: " + idMedic + '\n' +
                " Nume: " + name + '\n' +
                " Gen: " + gender + '\n' +
                " Adresa: " + address + '\n' +
                " Varsta: " + age + '\n' +
                " Grad Experienta: " + experienceLevel + '\n' +
                " Specializare: " + specialty + '\n' +
                "----------\n";
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
