package com.example.qr_readerexample;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.qr_readerexample.db.DBHelper;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main_View extends Activity {

    private TextView mainTextView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    private GoogleApiClient client;
    SQLiteDatabase db;
    DBHelper helper;
    String str;
    String cre_by;
    String cre_date;
    String remark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        helper = new DBHelper(Main_View.this, // 현재 화면의 context

                "warehouse7.db", // 파일명

                null, // 커서 팩토리

                1); // 버전 번호
        setContentView(R.layout.activity_main__view);

        Intent intent = getIntent();

        str = intent.getExtras().getString("string");

        cre_by = intent.getExtras().getString("cre_by");

        cre_date = intent.getExtras().getString("cre_date");

        remark = intent.getExtras().getString("remark");

        String[] strArr = str.split("/");

        insert_uns(strArr[0], strArr[1], strArr[2], strArr[3],Integer.parseInt(strArr[4]), Integer.parseInt(strArr[5]), Integer.parseInt(strArr[6]), Integer.parseInt(strArr[7]), cre_by, cre_date, remark);
        select_uns();

        super.onCreate(savedInstanceState);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main_View Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.qr_readerexample/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main_View Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.qr_readerexample/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
    public void MainToHomepage(View view)
    {
        Intent intent = new Intent(Main_View.this, DecoderActivity.class);
        startActivity(intent);
    }

    public void MainToScan(View view)
    {
        Intent intent = new Intent(Main_View.this, DecoderActivity.class);
        startActivity(intent);
    }

    public void insert_sto(String mrr_no, String item_no, String warehouse_date, int input_qty, int good_qty, int short_qty, int damage_qty, String cre_by, String cre_date, String remark) {

        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능



        ContentValues values = new ContentValues();

        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤

        // 데이터의 삽입은 put을 이용한다.

        values.put("mrr_no", mrr_no);
        values.put("item_no", item_no);
        values.put("warehouse_date", warehouse_date);
        values.put("input_qty", input_qty);
        values.put("good_qty", good_qty);
        values.put("short_qty", short_qty);
        values.put("damage_qty", damage_qty);
        values.put("remark", remark);
        values.put("cre_by", cre_by);
        values.put("cre_date", cre_date);



        db.insert("storing", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)

        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.

    }
    public void insert_uns(String mrr_no, String subcon_id, String item_no, String warehouse_date, int output_qty, int good_qty, int short_qty, int damage_qty, String cre_by, String cre_date, String remark) {

        db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능



        ContentValues values = new ContentValues();

        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤

        // 데이터의 삽입은 put을 이용한다.

        values.put("rss_no", mrr_no);
        values.put("subcon_id", subcon_id);
        values.put("item_no", item_no);
        values.put("warehouse_date", warehouse_date);
        values.put("output_qty", output_qty);
        values.put("good_qty", good_qty);
        values.put("short_qty", short_qty);
        values.put("damage_qty", damage_qty);
        values.put("remark", remark);
        values.put("cre_by", cre_by);
        values.put("cre_date", cre_date);



        db.insert("unstoring", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)

        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.

    }


    // update

    public void update (String name, int age) {

        db = helper.getWritableDatabase(); //db 객체를 얻어온다. 쓰기가능



        ContentValues values = new ContentValues();

        values.put("age", age);    //age 값을 수정

        db.update("student", values, "name=?", new String[]{name});

        /*

         * new String[] {name} 이런 간략화 형태가 자바에서 가능하다

         * 당연하지만, 별도로 String[] asdf = {name} 후 사용하는 것도 동일한 결과가 나온다.

         */



        /*

         * public int update (String table,

         * ContentValues values, String whereClause, String[] whereArgs)

         */

    }



    // delete

    public void delete (String mrr_no) {

        db = helper.getWritableDatabase();

        db.delete("ware_list", "mrr_no=?", new String[]{mrr_no});

        Log.i("db", mrr_no + "정상적으로 삭제 되었습니다.");

    }



    // select

    public void select_sto() {
        StringBuffer sb = new StringBuffer();
        String list;
        mainTextView = (TextView) findViewById(R.id.textView);
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용



        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용

        Cursor c = db.query("storing", null, null, null, null, null, null);




        /*

         * 위 결과는 select * from student 가 된다. Cursor는 DB결과를 저장한다. public Cursor

         * query (String table, String[] columns, String selection, String[]

         * selectionArgs, String groupBy, String having, String orderBy)

         */



        while (c.moveToNext()) {

            //int seq = c.getInt(c.getColumnIndex("seq"));
            //sb.append(seq);
            String mrr_no = c.getString(c.getColumnIndex("mrr_no"));
            String item_no = c.getString(c.getColumnIndex("item_no"));
            String warehouse_date = c.getString(c.getColumnIndex("warehouse_date"));
            int input_qty = c.getInt(c.getColumnIndex("input_qty"));
            int good_qty = c.getInt(c.getColumnIndex("good_qty"));
            int short_qty = c.getInt(c.getColumnIndex("short_qty"));
            int damage_qty = c.getInt(c.getColumnIndex("damage_qty"));
            String remark = c.getString(c.getColumnIndex("remark"));
            String cre_by = c.getString(c.getColumnIndex("cre_by"));
            String cre_date = c.getString(c.getColumnIndex("cre_date"));
            sb.append("입고번호 : ");
            sb.append(mrr_no);
            sb.append('\n');
            sb.append("자재번호 : ");
            sb.append(item_no);
            sb.append('\n');
            sb.append("입고날짜 : ");
            sb.append(warehouse_date);
            sb.append('\n');
            sb.append("입고수량 : ");
            sb.append(input_qty);
            sb.append('\n');
            sb.append("정상수량 : ");
            sb.append(good_qty);
            sb.append('\n');
            sb.append("부분결함수량 : ");
            sb.append(short_qty);
            sb.append('\n');
            sb.append("파손수량 : ");
            sb.append(damage_qty);
            sb.append('\n');
            sb.append("비고 : ");
            sb.append(remark);
            sb.append('\n');
            sb.append("검수자 : ");
            sb.append(cre_by);
            sb.append('\n');
            sb.append("검수일자 : ");
            sb.append(cre_date);
            sb.append('\n');

        }
        list = sb.toString();
        mainTextView.setText(list);
    }

    public void select_uns() {
        StringBuffer sb = new StringBuffer();
        String list;
        mainTextView = (TextView) findViewById(R.id.textView);
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용



        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용

        Cursor c = db.query("unstoring", null, null, null, null, null, null);




        /*

         * 위 결과는 select * from student 가 된다. Cursor는 DB결과를 저장한다. public Cursor

         * query (String table, String[] columns, String selection, String[]

         * selectionArgs, String groupBy, String having, String orderBy)

         */



        while (c.moveToNext()) {

            //int seq = c.getInt(c.getColumnIndex("seq"));
            //sb.append(seq);
            String rss_no = c.getString(c.getColumnIndex("rss_no"));
            String subcon_id = c.getString(c.getColumnIndex("subcon_id"));
            String item_no = c.getString(c.getColumnIndex("item_no"));
            String warehouse_date = c.getString(c.getColumnIndex("warehouse_date"));
            int output_qty = c.getInt(c.getColumnIndex("output_qty"));
            int good_qty = c.getInt(c.getColumnIndex("good_qty"));
            int short_qty = c.getInt(c.getColumnIndex("short_qty"));
            int damage_qty = c.getInt(c.getColumnIndex("damage_qty"));
            String remark = c.getString(c.getColumnIndex("remark"));
            String cre_by = c.getString(c.getColumnIndex("cre_by"));
            String cre_date = c.getString(c.getColumnIndex("cre_date"));
            sb.append("출고번호 : ");
            sb.append(rss_no);
            sb.append('\n');
            sb.append("업체번호 : ");
            sb.append(subcon_id);
            sb.append('\n');
            sb.append("자재번호 : ");
            sb.append(item_no);
            sb.append('\n');
            sb.append("출고날짜 : ");
            sb.append(warehouse_date);
            sb.append('\n');
            sb.append("출고수량 : ");
            sb.append(output_qty);
            sb.append('\n');
            sb.append("정상수량 : ");
            sb.append(good_qty);
            sb.append('\n');
            sb.append("부분결함수량 : ");
            sb.append(short_qty);
            sb.append('\n');
            sb.append("파손수량 : ");
            sb.append(damage_qty);
            sb.append('\n');
            sb.append("비고 : ");
            sb.append(remark);
            sb.append('\n');
            sb.append("검수자 : ");
            sb.append(cre_by);
            sb.append('\n');
            sb.append("검수일자 : ");
            sb.append(cre_date);
            sb.append('\n');

        }
        list = sb.toString();
        mainTextView.setText(list);
    }
}
