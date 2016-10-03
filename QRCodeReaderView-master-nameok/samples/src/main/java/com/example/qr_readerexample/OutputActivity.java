package com.example.qr_readerexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OutputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
    }

    public void OutputToHomepage(View view)
    {
        Intent intent = new Intent(OutputActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
