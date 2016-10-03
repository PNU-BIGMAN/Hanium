package com.example.qr_readerexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



/*

 * sql을 사용하기 위한 제반 클래스

* SQLiteOpenHelper는 사용에 도움을 주는 클래스이다.

 */

public class DBHelper extends SQLiteOpenHelper {



    public DBHelper(Context context, String name,

                    CursorFactory factory, int version) {

        super(context, name, factory, version);

        // TODO Auto-generated constructor stub



    }



    @Override

    public void onCreate(SQLiteDatabase db) {

        // TODO Auto-generated method stub

        // SQLiteOpenHelper 가 최초 실행 되었을 때

        String sql = "create table storing (" +

                "mrr_no text, " +

                "item_no text, " +

                "warehouse_date text, " +

                "input_qty integer, " +

                "good_qty integer, " +

                "short_qty integer, " +

                "damage_qty integer, " +

                "remark text, " +

                "cre_by text, " +

                "cre_date text, PRIMARY KEY(mrr_no));";
        String sql2 = "create table unstoring (" +

                "rss_no text, " +

                "subcon_id text, " +

                "item_no text, " +

                "warehouse_date text, " +

                "output_qty integer, " +

                "good_qty integer, " +

                "short_qty integer, " +

                "damage_qty integer, " +

                "remark text, " +

                "cre_by text, " +

                "cre_date text, PRIMARY KEY(rss_no));";


        db.execSQL(sql);
        db.execSQL(sql2);

    }



    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // db = 적용할 db, old/new 구 버전/신버전

        // TODO Auto-generated method stub

        /*

         * db 버전이 업그레이드 되었을 때 실행되는 메소드

         * 이 부분은 사용에 조심해야 하는 일이 많이 있다. 버전이 1인 사용자가 2로 바뀌면

         * 한번의 수정만 하면 되지만 버전이 3으로 되면 1인 사용자가 2, 3을 거쳐야 하고

         * 2인 사용자는 3 까지만 거치면 된다. 이렇게 증가할 수록 수정할 일이 많아지므로

         * 적절히 사용해야 하며 가능하면 최초 설계 시에 완벽을 기하는 것이 가장 좋을 것이다.

         * 테스트에서는 기존의 데이터를 모두 지우고 다시 만드는 형태로 하겠다.

         */



        String sql = "drop table if exists storing";

        db.execSQL(sql);

        String sql2 = "drop table if exists unstoring";

        db.execSQL(sql);


        onCreate(db); // 테이블을 지웠으므로 다시 테이블을 만들어주는 과정

    }

}
