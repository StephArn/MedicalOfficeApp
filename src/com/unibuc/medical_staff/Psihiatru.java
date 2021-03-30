package com.unibuc.medical_staff;

public class Psihiatru extends CadruMedical{
    private int experienceLevel;
    static final double[] payBonus = {4, 9, 14, 19};

    public Psihiatru(String n, String g, String add, int a, double base_salary, int el) {
        super(n, g, add, a, base_salary);
        this.experienceLevel = el;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + baseSalary * payBonus[experienceLevel]/100;
    }

    @Override
    public String toString() {
        return "Medic Psihiatru \n" +
                " ID: " + idMedic + '\n' +
                " Nume: " + name + '\n' +
                " Gen: " + gender + '\n' +
                " Adresa: " + address + '\n' +
                " Varsta: " + age + '\n' +
                " Grad Experienta: " + experienceLevel + '\n' +
                "----------\n";
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
