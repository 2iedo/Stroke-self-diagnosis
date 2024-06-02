package com.example.demo.DTO;

public class UserInfo {
    private int gender;
    private int age;
    private int hypertension;
    private int heartdisease;
    private int everMarried;
    private int workType;
    private int residenceType = 1;
    private double avgGlucoseLevel = 106.14;
    private double bmi;
    private int smokingStatus;
    private double strokePercent;

    public UserInfo(int gender, int age, int hypertension, int heartdisease, int everMarried,
        int workType, double bmi, int smokingStatus) {
        this.gender = gender;
        this.age = age;
        this.hypertension = hypertension;
        this.heartdisease = heartdisease;
        this.everMarried = everMarried;
        this.workType = workType;
        this.bmi = bmi;
        this.smokingStatus = smokingStatus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHypertension() {
        return hypertension;
    }

    public void setHypertension(int hypertension) {
        this.hypertension = hypertension;
    }

    public int getHeartdisease() {
        return heartdisease;
    }

    public void setHeartdisease(int heartdisease) {
        this.heartdisease = heartdisease;
    }

    public int getEverMarried() {
        return everMarried;
    }

    public void setEverMarried(int everMarried) {
        this.everMarried = everMarried;
    }

    public int getWorkType() {
        return workType;
    }

    public void setWorkType(int workType) {
        this.workType = workType;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(int smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getStrokePercent() {
        return strokePercent;
    }

    public void setStrokePercent(double strokePercent) {
        this.strokePercent = strokePercent;
    }

    public int getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(int residenceType) {
        this.residenceType = residenceType;
    }

    public double getAvgGlucoseLevel() {
        return avgGlucoseLevel;
    }

    public void setAvgGlucoseLevel(double avgGlucoseLevel) {
        this.avgGlucoseLevel = avgGlucoseLevel;
    }
}
