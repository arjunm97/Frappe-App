package com.endlessbay.arjun.frappe.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.endlessbay.arjun.frappe.Interface.ItemClickListner;
import com.endlessbay.arjun.frappe.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food_name;
    public ImageView food_image;

    private ItemClickListner itemClickListner;


    public void setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner=itemClickListner;

    }


    public FoodViewHolder(View itemView) {
        super(itemView);
        food_name=(TextView)itemView.findViewById(R.id.food_name);
        food_image=(ImageView)itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
    itemClickListner.onClick(view,getAdapterPosition(),false);
    }
}
