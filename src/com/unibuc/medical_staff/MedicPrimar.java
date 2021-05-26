package com.unibuc.medical_staff;

public class MedicPrimar extends CadruMedical{
    private String specialisation;
    private int experienceLevel;
    static final double[] payBonus = {5, 10, 15, 20};

    public MedicPrimar(String n, String g, String add, int a, double baseSalary, String specialisation, int el) {
        super(n, g, add, a, baseSalary);
        this.specialisation = specialisation;
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
                " Specializare: " + specialisation + '\n' +
                "----------\n";
    }

    @Override
    public void showMedicalStaff() {
        System.out.println(toString());
        System.out.println(" Salariu: " + calculateSalary() + "\n----------\n");
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
