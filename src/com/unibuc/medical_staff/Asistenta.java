package com.unibuc.medical_staff;

public class Asistenta extends CadruMedical {
    private int experienceLevel;
    static final double[] payBonus = {3, 5, 7, 10};

    public Asistenta(String n, String g, String add, int a, double base_salary, int el) {
        super(n, g, add, a, base_salary);
        this.experienceLevel = el;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + baseSalary * payBonus[experienceLevel]/100;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
