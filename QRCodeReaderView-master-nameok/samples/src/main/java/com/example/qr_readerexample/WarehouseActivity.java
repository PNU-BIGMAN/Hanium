package com.example.qr_readerexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class WarehouseActivity extends Activity {
    TextView textV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        textV = (TextView) findViewById(R.id.tf);
        new JsonLoadingTask().execute();

    }

    public void WareToHomepage(View view)
    {
        Intent intent = new Intent(WarehouseActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public String getJsonText() {
        StringBuffer sb = new StringBuffer();
        sb.append("-- 2016년 9월 25일 입고 현황 --\n");
        try{
            String line  = getStringFromUrl("http://14.63.215.207:3000/search/storing");


            JSONObject object = new JSONObject(line);
            JSONArray Array = new JSONArray(object.getString("data"));

            for (int i = 0; i < Array.length(); i++) {
                // bodylist 배열안에 내부 JSON 이므로 JSON 내부 객체 생성
                JSONObject insideObject = Array.getJSONObject(i);

                // StringBuffer 메소드 ( append : StringBuffer 인스턴스에 뒤에 덧붙인다. )
                // JSONObject 메소드 ( get.String(), getInt(), getBoolean() .. 등 : 객체로부터 데이터의 타입에 따라 원하는 데이터를 읽는다. )

                sb.append("자재 번호 : ").append(insideObject.getString("item_no")).append("\n");
                sb.append("입고 날짜 : ").append(insideObject.getString("warehouse_date")).append("\n");
                sb.append("입고 수량 : ").append(insideObject.getString("input_qty")).append("\n");
                sb.append("\n");

            } // for
        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return sb.toString();
    }


    //데이터 저장
    public  String getStringFromUrl(String url) throws UnsupportedOperationException, UnsupportedEncodingException {

        // 입력 스트림을 euc-kr를 사용해서 읽은 후  이를 사용해서
        // 라인단위로 데이터를 읽을수 있는 BufferReader를 생성한다
        BufferedReader br = new BufferedReader(new InputStreamReader(getInputStreamFromUrl(url),"UTF-8"));   //(new InputStreamReader(url,"UTF-8"));

        //읽은 데이터를 저장할 StringBuffer를 생성한다
        StringBuffer sb = new StringBuffer();

        try{
            //라인 단위로 읽은 데이터를 임시 저장할 자열 변수
            String line = null;

            //라인 단위로 데이터를 읽어서 StringBuffer에 저장한다
            while ((line = br.readLine()) != null){
                sb.append(line);
                Log.e("TTL",line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return  sb.toString();

    }




    //url 커넥션
    public  static InputStream getInputStreamFromUrl(String url){
        InputStream contentStream = null;

        try{
            URL reauestURL  = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) reauestURL.openConnection();
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                contentStream = conn.getInputStream();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return  contentStream;
    }





    //결과 출력  onPostExecute 에서 ui접근
    private class JsonLoadingTask extends AsyncTask<String, Void,String>{
        @Override
        protected String doInBackground(String... params) {
            return  getJsonText();

        }

        protected void onPostExecute(String result){
            textV.setText(result);


        }


    }
}
