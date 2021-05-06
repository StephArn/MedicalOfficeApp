package com.unibuc;

public abstract class Persoana {
    protected String name;
    protected String gender;
    protected String address;
    protected int age;

    public Persoana(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
