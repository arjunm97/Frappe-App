package com.endlessbay.arjun.frappe.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.endlessbay.arjun.frappe.Interface.ItemClickListner;
import com.endlessbay.arjun.frappe.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageeView;

    private ItemClickListner itemClickListner;

    public MenuViewHolder(View itemView) {
        super(itemView);
        txtMenuName=(TextView)itemView.findViewById(R.id.menu_name);
        imageeView=(ImageView)itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);

    }
    public void setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner=itemClickListner;

    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition(),false);
    }
}
