package com.unibuc.appointment;
import com.unibuc.medical_staff.CadruMedical;
import com.unibuc.patient.Pacient;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Programare {

    private CadruMedical assignedDoctor;
    private Pacient patient;
    private Date dateOfAppointment;
    private LocalTime timeOfAppointment;
    private String diagnostic;
    protected int idProgramare;
    static int idIncrement = 0;

    {
        this.idProgramare = ++idIncrement;
    }

    public Programare(CadruMedical assignedDoctor, Pacient patient, String diagnostic, Date date, LocalTime time) {
        this.assignedDoctor = assignedDoctor;
        this.patient = patient;
        this.dateOfAppointment = date;
        this.timeOfAppointment = time;
        this.diagnostic = diagnostic;
    }

//    public showAppointment(){
//        System.out.println("Date pacient:");
//        System.out.println();
//        System.out.println();
//    }


    public int getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }

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

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    @Override
    public String toString() {
        return "Programare \n" +
                " ID Programare: " + idProgramare + '\n' +
                " ID Medic: " + assignedDoctor.getIdMedic() + '\n' +
                " ID Medic: " + patient.getIdPacient() + '\n' +
                " Data: " + dateOfAppointment + '\n' +
                " Ora: " + timeOfAppointment + '\n' +
                " Diagnostic: " + diagnostic + '\n' +
                "----------\n";
    }
}
