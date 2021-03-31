package com.unibuc.medical_staff;

import com.unibuc.patient.Pacient;

import java.util.Comparator;

public class ComparatorStaffName implements Comparator<CadruMedical> {
    @Override
    public int compare(CadruMedical o1, CadruMedical o2) {
        return o1.getName().compareTo(o2.getName());
    }
}