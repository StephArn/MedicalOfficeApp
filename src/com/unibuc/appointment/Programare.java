package com.unibuc.appointment;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.patient.Pacient;

import java.time.LocalDateTime;

public class Programare {

    private CadruMedical assignedDoctor;
    private Pacient patient;
    private LocalDateTime timeOfAppointment;
    private String diagnostic;

    public Programare(CadruMedical assignedDoctor, Pacient patient, String diagnostic) {
        this.assignedDoctor = assignedDoctor;
        this.patient = patient;
        this.timeOfAppointment = LocalDateTime.now();
        this.diagnostic = diagnostic;
    }

//    public showAppointment(){
//        System.out.println("Date pacient:");
//        System.out.println();
//        System.out.println();
//    }


    public CadruMedical getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(CadruMedical assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public Pacient getPatient() {
        return patient;
    }

    public void setPatient(Pacient patient) {
        this.patient = patient;
    }

    public LocalDateTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(LocalDateTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }
}
