package com.example.demo.DTO;

public class HospitalInfo {
    private String address;
    private String hospitalName;
    private String hospitalOpening;
    private String hospitalClosing;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalOpening() {
        return hospitalOpening;
    }

    public void setHospitalOpening(String hospitalOpening) {
        this.hospitalOpening = hospitalOpening;
    }

    public String getHospitalClosing() {
        return hospitalClosing;
    }

    public void setHospitalClosing(String hospitalClosing) {
        this.hospitalClosing = hospitalClosing;
    }
}
