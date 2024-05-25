package com.example.demo.Utility;

import com.example.demo.DTO.HospitalInfo;
import com.example.demo.DTO.PatientInfo;
import java.util.ArrayList;

public class Search {
    private HospitalInfo hospitalInfo;

    public HospitalInfo startSearch(){
        // 병원 리스트를 가져오기
        ArrayList<HospitalInfo> list = getHospitalList();

        hospitalInfo = null;

        //프론트에서 받는 동안 기다림
        while(hospitalInfo == null){
            hospitalInfo = getHospitalInfo();
        }

        return hospitalInfo;
    }

    //선택한 병원 정보를 리턴하는 함수
    public HospitalInfo getHospitalInfo(){
        HospitalInfo res = null;

        return res;
    }

    //병원의 정보 리스트를 받는 함수
    public ArrayList<HospitalInfo> getHospitalList(){
        ArrayList<HospitalInfo> list = new ArrayList<HospitalInfo>();

        //api로부터 병원 정보 받아서 list에 추가

        return list;
    }

    public String getUserGps(){
        String gpsInfo = "";
        return gpsInfo;
    }
}
