package com.endlessbay.arjun.frape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class admin extends AppCompatActivity {
    String value1;
    EditText number;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }
    public void submitButton(View view) throws IOException {
        number= findViewById(R.id.passkey);
        name=findViewById(R.id.namey);

        FileOutputStream fOut = openFileOutput("info",MODE_WORLD_READABLE);

        try {
            fOut.write(name.getText().toString().getBytes());
            fOut.write(number.getText().toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fOut.close();


    }



}

