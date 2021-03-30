package com.unibuc;

import com.unibuc.medical_staff.Asistent;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;

public class Main {

    public static void main(String[] args) {
        CadruMedical a = new Asistent("Ana Ionescu","Feminim","Bucuresti,Nucului nr.45",34,8000,2);
        CadruMedical mp = new MedicPrimar("Anda Florea", "Feminim","Bucuresti, Pacii nr. 4", 43, 10000,"cardiologie", 3);
        CadruMedical p = new Psihiatru("Mihail Banea","Masculin","Bucuresti, Aviatiei nr. 56", 46, 9500, 3);
//        System.out.print(a.calculateSalary());
//        System.out.println();
//        System.out.print(mp.calculateSalary());
//        System.out.println();
//        System.out.print(p.calculateSalary());

        System.out.println(a);
        System.out.println(mp);
        System.out.println(p);

    }
}
