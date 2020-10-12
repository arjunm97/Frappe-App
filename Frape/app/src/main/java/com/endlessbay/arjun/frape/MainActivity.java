package com.endlessbay.arjun.frape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void menuy(View view){
        Intent intent1=new Intent(this,menu.class);
        startActivity(intent1);
        }

        public void adminy(View view){
        Intent intent2=new Intent(this,admin.class);
        startActivity(intent2);
        }
}
