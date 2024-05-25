package com.example.demo.Utility;

import com.example.demo.DTO.ReservationInfo;

public class Alarm {
    //화면에 알람 보내는 메소드
    public String sendAlarm(ReservationInfo reservationInfo){
        String str = reservationInfo.getDate();
        //팝업 형태로 예약날짜 확인
        return str;
    }

    //병원에 알람 보내는 메소드
    public String sendEmerAlarm(ReservationInfo reservationInfo){
        String str = reservationInfo.getDate();
        //팝업 형태로 예약 날짜 보냈다는 내용 올림
        return str;
    }
}
