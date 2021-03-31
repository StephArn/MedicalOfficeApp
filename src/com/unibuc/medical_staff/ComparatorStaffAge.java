package com.unibuc.medical_staff;

import java.util.Comparator;

public class ComparatorStaffAge implements Comparator<CadruMedical>{

    @Override
    public int compare(CadruMedical o1, CadruMedical o2) {
        return o2.getAge() - o1.getAge();
    }
}