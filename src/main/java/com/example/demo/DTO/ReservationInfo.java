package com.example.demo.DTO;

public class ReservationInfo {
    private PatientInfo patientInfo;
    private HospitalInfo hospitalInfo;

    public ReservationInfo(PatientInfo patientInfo, HospitalInfo hospitalInfo) {
        this.patientInfo = patientInfo;
        this.hospitalInfo = hospitalInfo;
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
