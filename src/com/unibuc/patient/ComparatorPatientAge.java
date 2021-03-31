package com.unibuc.patient;

import java.util.Comparator;

public class ComparatorPatientAge implements Comparator<Pacient> {
    @Override
    public int compare(Pacient o1, Pacient o2) {
        return o2.getAge() - o1.getAge();
    }
}