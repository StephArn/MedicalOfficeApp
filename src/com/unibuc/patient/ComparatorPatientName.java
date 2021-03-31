package com.unibuc.patient;

import java.util.Comparator;

public class ComparatorPatientName implements Comparator<Pacient> {
    @Override
    public int compare(Pacient o1, Pacient o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
