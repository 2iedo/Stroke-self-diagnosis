package com.example.demo.DTO;

public class ReservationInfo {
    private String date;
    private PatientInfo patientInfo;
    private HospitalInfo hospitalInfo;

    public ReservationInfo(String date, PatientInfo patientInfo, HospitalInfo hospitalInfo) {
        this.date = date;
        this.patientInfo = patientInfo;
        this.hospitalInfo = hospitalInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public HospitalInfo getHospitalInfo() {
        return hospitalInfo;
    }

    public void setHospitalInfo(HospitalInfo hospitalInfo) {
        this.hospitalInfo = hospitalInfo;
    }
}
