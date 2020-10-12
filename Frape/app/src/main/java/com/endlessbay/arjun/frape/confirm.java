package com.endlessbay.arjun.frape;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class confirm extends AppCompatActivity {
    String orders;
    int bill;
    EditText c_name,c_number;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        mdatabase=FirebaseDatabase.getInstance().getReference();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            orders = extras.getString("Order");
            bill=extras.getInt("Bill");
        }


    }

    public  void final_order(View view){

        c_name=findViewById(R.id.customer_name);
        c_number=findViewById(R.id.phone);

        if (c_name.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_LONG).show();
            //return;

        }
        if (c_number.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Enter your Phone number", Toast.LENGTH_LONG).show();
           // return;

        }

        else{

            //sever code;

           Toast.makeText(this, orders, Toast.LENGTH_SHORT).show();
            HashMap<String,String> dataMap=new HashMap<String, String>();
            //bill,orders,name,phone no;

            dataMap.put("Name",c_name.getText().toString());
            dataMap.put("Phone",c_number.getText().toString());
            dataMap.put("Order",orders);
            dataMap.put("Bill",Integer.toString(bill));
            mdatabase.push().setValue(dataMap);
        }



    }

}
