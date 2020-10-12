package com.endlessbay.arjun.frappe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.endlessbay.arjun.frappe.Common.Common;
import com.endlessbay.arjun.frappe.Database.Database;
import com.endlessbay.arjun.frappe.Model.Order;
import com.endlessbay.arjun.frappe.Model.Request;
import com.endlessbay.arjun.frappe.ViewHolder.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    
    FirebaseDatabase database;
    DatabaseReference requests;
    
    TextView txtTotalPrice;
    Button btnPlace;
    
    List<Order> cart=new ArrayList<>();
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        
        database=FirebaseDatabase.getInstance();
        requests=database.getReference("Requests");
        
        recyclerView=findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        txtTotalPrice=(TextView)findViewById(R.id.total);
        btnPlace=findViewById(R.id.btnPlaceOrder);

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cart.size() >0){
               showAlertDialog();
            }
            else{
                    Toast.makeText(Cart.this,"Add Food to cart",Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        loadListFood();
        
    }
    private void showAlertDialog(){
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(Cart.this);
        alertDialog.setTitle("Enter Information(last step)");
        alertDialog.setMessage("Phone-no,Name,Arrival time");
        //alertDialog.setMessage("Phone-no");
        final EditText phone=new EditText(Cart.this);
        final EditText name=new EditText(Cart.this);
        final EditText time=new EditText(Cart.this);
        LinearLayout lila1= new LinearLayout(this);
        lila1.setOrientation(LinearLayout.VERTICAL); //1 is for vertical orientation
        phone.setHint("Enter Phone Number");
        lila1.addView(phone);
        //alertDialog.setMessage("Name");
        name.setHint("Enter Name");
        lila1.addView(name);
        //alertDialog.setMessage("Arrival time");
        time.setHint("Enter time of arrival");
        lila1.addView(time);
        alertDialog.setView(lila1);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Request request=new Request(phone.getText().toString(),name.getText().toString(),time.getText().toString(),
                        txtTotalPrice.getText().toString(),cart);

                requests.child(String.valueOf(System.currentTimeMillis())).setValue(request);
                new Database(getBaseContext()).cleanCart();
                Toast.makeText(Cart.this,"Order Placed",Toast.LENGTH_SHORT).show();
                finish();
            }


        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

               alertDialog.show();


    }

    private void loadListFood() {

        cart= new Database(this).getCarts();
        adapter=new CartAdapter(cart,this);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        int total =0;
        for(Order order:cart){

            total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getQuantity()));


        }
        Locale locale=new Locale("en","US");
        NumberFormat fmt=NumberFormat.getCurrencyInstance(locale);

        txtTotalPrice.setText(fmt.format(total));
    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle().equals(Common.DELETE))
            deleteCart(item.getOrder());
        return true;
    }

    private void deleteCart(int position) {
        cart.remove(position);
        new Database(this).cleanCart();
        for (Order item:cart)
            new Database(this).addToCart(item);



        loadListFood();
    }

}
