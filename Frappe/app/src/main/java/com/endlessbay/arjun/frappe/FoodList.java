package com.endlessbay.arjun.frappe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.endlessbay.arjun.frappe.Interface.ItemClickListner;
import com.endlessbay.arjun.frappe.Model.Food;
import com.endlessbay.arjun.frappe.ViewHolder.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodlist;
    String categoryId="";
    FirebaseRecyclerAdapter<Food,FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        database=FirebaseDatabase.getInstance();
        foodlist=database.getReference("Foods");

        recyclerView =findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null){


            categoryId=getIntent().getStringExtra("CategoryId");

        }
        if (!categoryId.isEmpty() && categoryId != null){

            loadListFood(categoryId);
        }


    }

    private void loadListFood(String categoryId) {

        adapter=new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,R.layout.food_item,FoodViewHolder.class,
                foodlist.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
                viewHolder.food_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.food_image);

                final Food local=model;
                //Toast.makeText(FoodList.this,"working",Toast.LENGTH_SHORT).show();
                viewHolder.setItemClickListner(new ItemClickListner() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Toast.makeText(FoodList.this,""+local.getName(),Toast.LENGTH_SHORT).show();
                        //Toast.makeText(FoodList.this,"working",Toast.LENGTH_SHORT).show();

                        Intent foodDetail =new Intent(FoodList.this,FoodDetail.class);
                        foodDetail.putExtra("FoodId",adapter.getRef(position).getKey());
                        startActivity(foodDetail);
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
    }
}
