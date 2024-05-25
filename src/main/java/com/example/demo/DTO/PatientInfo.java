package com.example.demo.DTO;

public class PatientInfo extends UserInfo{
    private String name;
    private String birthday;
    private String address;
    private String phone;
    private String anamnesis;

    public PatientInfo(int gender, int age, int hypertension, int heartdisease, int everMarried,
        int workType, double bmi, int smokingStatus, int strokePercent, String name,
        String birthday,
        String address, String phone, String anamnesis) {
        super(gender, age, hypertension, heartdisease, everMarried, workType, bmi, smokingStatus,
            strokePercent);
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.anamnesis = anamnesis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }
}
