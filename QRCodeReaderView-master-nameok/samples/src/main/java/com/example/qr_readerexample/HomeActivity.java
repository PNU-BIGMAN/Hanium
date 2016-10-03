package com.example.qr_readerexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void ToScanpage(View view)
    {
        Intent intent = new Intent(HomeActivity.this, DecoderActivity.class);
        startActivity(intent);
    }

    public void ToWarehouse(View view)
    {
        Intent intent = new Intent(HomeActivity.this, WarehouseActivity.class);
        startActivity(intent);
    }
    public void ToOutput(View view)
    {
        Intent intent = new Intent(HomeActivity.this, OutputActivity.class);
        startActivity(intent);
    }
    public void ToItem(View view)
    {
        Intent intent = new Intent(HomeActivity.this, ItemActivity.class);
        startActivity(intent);
    }
}
