package com.unibuc.medical_staff;

public class MedicPrimar extends CadruMedical{
    private String specialisation;
    private int experienceLevel;
    static final double[] payBonus = {5, 10, 15, 20};

    public MedicPrimar(String n, String g, String add, int a, double base_salary, String specialisation, int el) {
        super(n, g, add, a, base_salary);
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

    public String getspecialisation() {
        return specialisation;
    }

    public void setspecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
