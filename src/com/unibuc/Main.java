package com.unibuc;

import com.unibuc.medical_staff.Asistenta;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.medical_staff.MedicPrimar;
import com.unibuc.medical_staff.Psihiatru;

public class Main {

    public static void main(String[] args) {
        CadruMedical a = new Asistenta("Ana Ionescu","Feminim","Bucuresti,Nucului nr.45",34,8000,2);
        CadruMedical mp = new MedicPrimar("Anda Florea", "Feminim","Bucuresti, Pacii nr. 4", 43, 10000,"cardiologie", 3);
        CadruMedical p = new Psihiatru("Mihail Banea","Masculin","Bucuresti, Aviatiei nr. 56", 46, 9500, 3);

    }
}
