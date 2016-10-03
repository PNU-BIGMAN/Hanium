package com.example.qr_readerexample;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AfterScanActivity extends Activity {
    EditText editText1, editText2, editText3;
    String str;

    String cre_by;
    String cre_date;
    String remark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);
        editText1 = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);

        Intent intent = getIntent();

        str = intent.getExtras().getString("string");
    }
    public void ButtonClick(View view)
    {
        setContentView(R.layout.activity_after_scan);
        cre_by = editText1.getText().toString();
        cre_date = editText2.getText().toString();
        remark = editText3.getText().toString();
        Intent intent = new Intent(this, Main_View.class);
        intent.putExtra("string", str);
        intent.putExtra("cre_by", cre_by);
        intent.putExtra("cre_date", cre_date);
        intent.putExtra("remark", remark);
        startActivity(intent);
    }
}
