package com.example.admin.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.admin.demo.Interface.ItemClickListener;
import com.example.admin.demo.Model.Category;
import com.example.admin.demo.Model.Xe;
import com.example.admin.demo.ViewHolder.MenuViewHolder;
import com.example.admin.demo.ViewHolder.XeViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class XeList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference xelist;
    String categoryId ="";
    FirebaseRecyclerAdapter<Xe,XeViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xe_list);
        database = FirebaseDatabase.getInstance();
        xelist = database.getReference("Xe");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_xe);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (getIntent()!=null)
            categoryId =getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId !=null){
            loadlistxe(categoryId);
        }

    }

    private void loadlistxe(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Xe, XeViewHolder>(Xe.class,
                R.layout.xe_item,
                XeViewHolder.class,
                xelist.orderByChild("MenuId").equalTo(categoryId)
                ) {
            @Override
            protected void populateViewHolder(XeViewHolder viewHolder, Xe model, int position) {
                viewHolder.xe_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.xe_image);
                final  Xe xe = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(XeList.this,""+ xe.getName(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
    }
}
