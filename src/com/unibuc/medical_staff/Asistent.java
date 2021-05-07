package com.unibuc.medical_staff;

public class Asistent extends CadruMedical {
    private int experienceLevel;
    static final double[] payBonus = {3, 5, 7, 10};

    public Asistent(String n, String g, String add, int a, double baseSalary, int el) {
        super(n, g, add, a, baseSalary);
        this.experienceLevel = el;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + baseSalary * payBonus[experienceLevel]/100;
    }

    @Override
    public String toString() {
        return "Asistenta \n" +
                " ID: " + idMedic + '\n' +
                " Nume: " + name + '\n' +
                " Gen: " + gender + '\n' +
                " Adresa: " + address + '\n' +
                " Varsta: " + age + '\n' +
                " Grad Experienta: " + experienceLevel + '\n' +
                "----------\n";
    }

    @Override
    public void showMedicalStaff() {
        System.out.println(toString());
        System.out.println(" Salariu: " + calculateSalary() + "\n----------\n");
    }

//    public int getExperienceLevel() {
//        return experienceLevel;
//    }
//
//    public void setExperienceLevel(int experienceLevel) {
//        this.experienceLevel = experienceLevel;
//    }
}
