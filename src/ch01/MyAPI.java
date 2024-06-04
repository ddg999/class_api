package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MyAPI {

	public static void main(String[] args) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_lar_was_fee_api"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=cEmNLSJ25fQSn1%2B4G54EuUadGvnaAaiY37LcqaouafHMaVZ7d%2Bi%2F9UdneabMzD0esU42SDZ4BYzlSvsHo1%2F6TQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*XML/JSON 여부*/
        urlBuilder.append("&" + URLEncoder.encode("CTPV_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시도명*/
        urlBuilder.append("&" + URLEncoder.encode("SGG_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구명*/
        urlBuilder.append("&" + URLEncoder.encode("LAR_WAS_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*대형폐기물명*/
        urlBuilder.append("&" + URLEncoder.encode("LAR_WAS_SE_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*대형폐기물구분명*/
        urlBuilder.append("&" + URLEncoder.encode("LAR_WAS_SPCFCT","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*대형폐기물규격*/
        urlBuilder.append("&" + URLEncoder.encode("PAID_FREE_YN","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*유무료여부*/
        urlBuilder.append("&" + URLEncoder.encode("FEE","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*수수료*/
        urlBuilder.append("&" + URLEncoder.encode("MNG_INST_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관명*/
        urlBuilder.append("&" + URLEncoder.encode("CRTR_YMD","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*데이터기준일자*/
        urlBuilder.append("&" + URLEncoder.encode("instt_code","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관코드*/
        urlBuilder.append("&" + URLEncoder.encode("instt_nm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관기관명*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        System.out.println(sb.toString());
	}
}
