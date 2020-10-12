package com.endlessbay.arjun.frappe;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuy(View view){

        Intent conti=new Intent(MainActivity.this,Home.class);
        startActivity(conti);


    }
}
