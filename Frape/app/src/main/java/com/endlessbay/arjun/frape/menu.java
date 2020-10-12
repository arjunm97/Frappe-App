package com.endlessbay.arjun.frape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class menu extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32;
    CheckBox c33,c34,c35,c36,c37,c38,c39;
    int bill=0;
    ArrayList<String> orders=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    public void order_final(View view){
    //Getting all the checkboxes
        bill=0;
        StringBuilder result=new StringBuilder();
        c1=findViewById(R.id.burger);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox4);
        c4=findViewById(R.id.checkBox9);
        c5=findViewById(R.id.checkBox10);
        c6=findViewById(R.id.checkBox11);
        c7=findViewById(R.id.checkBox);
        c8=findViewById(R.id.checkBox3);
        c9=findViewById(R.id.checkBox5);
        c10=findViewById(R.id.checkBox6);
        c11=findViewById(R.id.checkBox7);
        c12=findViewById(R.id.checkBox8);
        c13=findViewById(R.id.checkBox12);
        c14=findViewById(R.id.checkBox13);
        c15=findViewById(R.id.checkBox14);
        c16=findViewById(R.id.checkBox15);
        c17=findViewById(R.id.checkBox16);
        c18=findViewById(R.id.checkBox17);
        c19=findViewById(R.id.checkBox18);
        c20=findViewById(R.id.checkBox19);
        c21=findViewById(R.id.checkBox20);
        c22=findViewById(R.id.checkBox21);
        c23=findViewById(R.id.checkBox22);
        c24=findViewById(R.id.checkBox23);
        c25=findViewById(R.id.checkBox24);
        c26=findViewById(R.id.checkBox25);
        c27=findViewById(R.id.checkBox27);
        c28=findViewById(R.id.checkBox28);
        c29=findViewById(R.id.checkBox29);
        c30=findViewById(R.id.checkBox30);
        c31=findViewById(R.id.checkBox31);
        c32=findViewById(R.id.checkBox32);
        c33=findViewById(R.id.checkBox33);
        c34=findViewById(R.id.checkBox34);
        c35=findViewById(R.id.checkBox35);
        c36=findViewById(R.id.checkBox36);






        if(c1.isChecked()){
           //kit kat
            bill=bill+100;
            result.append("Kitkat,100");
        }
        if(c2.isChecked()){
           //Snicker
            bill=bill+125;
            result.append("Snicker_Shake,125");

        }
        if (c3.isChecked()){
           //oreo
            bill=bill+50;
            result.append("Oreo,50");


        }
        if(c4.isChecked()){
            //Schezwan noodles
            bill=bill+50;
            result.append("Schezwan_Noodles,45");

        }
        if(c5.isChecked()){
            //Veg Maggie
            bill=bill+40;
            result.append("Veg_maggie,40");

        }
        if(c6.isChecked()){
            //Cheese maggie
            bill=bill+50;
            result.append("Cheese_Maggie,50");

        }
        if(c7.isChecked()){
            //
            bill=bill+50;
            result.append("Veg_Mayo_Sandwich,50");

        }
        if(c8.isChecked()){
            //
            bill=bill+65;
            result.append("cheese_sandwich,65");

        }
        if(c9.isChecked()){
            //
            bill=bill+50;
            result.append("Veg_burger,50");

        }
        if(c10.isChecked()){
            //cheese Burger
            bill=bill+55;
            result.append("Cheese_burger,55");

        }
        if(c11.isChecked()){
            //
            bill=bill+45;
            result.append("samosa_burger,45");

        }
        if(c12.isChecked()){
            //
            bill=bill+60;
            result.append("paneer_chilly,60");

        }
        if(c13.isChecked()){
            //
            bill=bill+50;
            result.append("aloo_paratha,50");

        }
        if(c14.isChecked()){
            //
            bill=bill+60;
            result.append("Mix_veg_paratha,60");

        }
        if(c15.isChecked()){
            //
            bill=bill+60;
            result.append("samosa_aloo_paratha,60");

        }
        if(c16.isChecked()){
            //
            bill=bill+50;
            result.append("Onion_paratha,50");

        }
        if(c17.isChecked()){
            //
            bill=bill+50;
            result.append("Veg_fried_rice,50");

        }
        if(c18.isChecked()){
            //
            bill=bill+60;
            result.append("schezwan_fried_rice-60,");

        }
        if(c19.isChecked()){
            //
            bill=bill+50;
            result.append("Jeera_rice-60,");

        }
        if(c20.isChecked()){
            //
            bill=bill+50;
            result.append("Veg_noodles-50,");

        }
        if(c21.isChecked()){
            //
            bill=bill+60;
            result.append("schezwan_noodles-60,");

        }
        if(c22.isChecked()){
            //
            bill=bill+30;
            result.append("Veg_wrap-30,");

        }
        if(c23.isChecked()){
            //
            bill=bill+40;
            result.append("Panner_wrap-40,");

        }
        if(c24.isChecked()){
            //
            bill=bill+60;
            result.append("mixed_veg_mom0-60,");

        }
        if(c25.isChecked()){
            //
            bill=bill+80;
            result.append("North_indian_thali-80,");

        }
        if(c26.isChecked()){
            //
            bill=bill+75;
            result.append("chocolate_shake-75,");

        }
        if(c27.isChecked()){
            //
            bill=bill+60;
            result.append("nachos-60,");

        }

        if(c28.isChecked()){
            //
            bill=bill+50;
            result.append("onion pakoda-,");

        }
        if(c29.isChecked()){
            //
            bill=bill+60;
            result.append("parathaa_aloo_onion-60,");

        }
        if(c30.isChecked()){
            //
            bill=bill+70;
            result.append("paratha aloo cheese-70,");

        }
        if(c31.isChecked()){
            //
            bill=bill+110;
            result.append("Margheritha pizza-110,");

        }
        if(c32.isChecked()){
            //
            bill=bill+80;
            result.append("cheese paratha-80,");

        }
        if(c33.isChecked()){
            //
            bill=bill+100;
            result.append("peanut butter 100,");

        }
        if(c34.isChecked()){
            //
            bill=bill+30;
            result.append("vada pav-30,");

        }
        if(c35.isChecked()){
            //
            bill=bill+40;
            result.append("vada pav cheese-40,");

        }
        if(c36.isChecked()){
            //
            bill=bill+60;
            result.append("hakka noodles-60,");

        }
        if(c37.isChecked()){
            //
            bill=bill+65;
            result.append("choco mocha-65,");

        }
        if(c38.isChecked()){
            //
            bill=bill+100;
            result.append("Frappacino-100,");

        }
        if(c39.isChecked()){
            //
            bill=bill+0;
            result.append("");

        }

        result.append("\nTotal: "+bill+"Rs");
        //Displaying the message on the toast
        //Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

        Intent con=new Intent(this,confirm.class);
        con.putExtra("Order",result.toString());
        con.putExtra("Bill",bill);
        startActivity(con);

    }


}
