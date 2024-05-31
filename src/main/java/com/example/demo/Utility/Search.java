package com.example.demo.Utility;

import com.example.demo.DTO.HospitalInfo;

import java.io.*;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Search {
    private HospitalInfo hospitalInfo;

    public HospitalInfo startSearch() throws IOException{
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
    public ArrayList<HospitalInfo> getHospitalList() throws IOException{
        try{
            ArrayList<HospitalInfo> list = new ArrayList<HospitalInfo>();

            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gm42V%2Byv5CuiOXqqXODcg1DIlV87gEaHTtrxedABKsknievEJE5Hpr7w%2BcIC5CKIG71LwQGCxcZrg%2BJvXvWrjA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("Q0","UTF-8") + "=" + URLEncoder.encode("대구광역시", "UTF-8")); /*주소(시도)*/
            urlBuilder.append("&" + URLEncoder.encode("Q1","UTF-8") + "=" + URLEncoder.encode("북구", "UTF-8")); /*주소(시군구)*/
            urlBuilder.append("&" + URLEncoder.encode("QZ","UTF-8") + "="); /*CODE_MST의'H000' 참조(B:병원, C:의원)*/
            urlBuilder.append("&" + URLEncoder.encode("QD","UTF-8") + "=" + URLEncoder.encode("D009", "UTF-8")); /*CODE_MST의'D000' 참조(D001~D029)*/
            urlBuilder.append("&" + URLEncoder.encode("QT","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*월~일요일(1~7), 공휴일(8)*/
            urlBuilder.append("&" + URLEncoder.encode("QN","UTF-8") + "="); /*기관명*/
            urlBuilder.append("&" + URLEncoder.encode("ORD","UTF-8") + "=" + URLEncoder.encode("NAME", "UTF-8")); /*순서*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            String response = sb.toString();
            response = response.replaceAll("<dutyInf>.*?</dutyInf>", ""); // dutyInf 필드를 제거

            // 응답 XML 데이터를 문자열로 가져오기
            String xmlResponse = response.toString();

            // XML 데이터를 Document 객체로 파싱
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlResponse)));

            // XML 문서의 루트 요소 가져오기
            document.getDocumentElement().normalize();

            // "item" 요소 목록 가져오기
            NodeList itemList = document.getElementsByTagName("item");

            // 각 "item" 요소를 순회하며 데이터 추출
            for (int i = 0; i < itemList.getLength(); i++) {
                String address = document.getElementsByTagName("dutyAddr").item(i).getTextContent();
                String hospitalName = document.getElementsByTagName("dutyName").item(i).getTextContent();
                String hospitalOpening = document.getElementsByTagName("dutyTime1s").item(i).getTextContent();
                String hospitalClosing = document.getElementsByTagName("dutyTime1c").item(i).getTextContent();

                list.add(new HospitalInfo(address, hospitalName, hospitalOpening, hospitalClosing));
            }
            return list;
        }
        catch(Exception e){
            System.out.println("에러 생김");
            return null;
        }
    }

    public String getUserGps(){
        String gpsInfo = "";
        return gpsInfo;
    }
}
