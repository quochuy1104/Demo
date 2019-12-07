package com.example.admin.demo.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.demo.Interface.ItemClickListener;
import com.example.admin.demo.R;

/**
 * Created by ADMIN on 12/7/2019.
 */

public class XeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView xe_name;
    public ImageView xe_image;
    private ItemClickListener itemClickListener;

    public XeViewHolder(View itemView) {
        super(itemView);
        xe_name= (TextView)itemView.findViewById(R.id.menu_name);
        xe_image= (ImageView) itemView.findViewById(R.id.xe_image);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
     public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
