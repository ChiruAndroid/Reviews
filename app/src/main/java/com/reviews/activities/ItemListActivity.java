package com.reviews.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.reviews.R;
import com.reviews.adapters.HomeAdapter;

public class ItemListActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back_img_list, filter_list;
    RecyclerView list_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        initializeViews();
    }

    private void initializeViews() {
        back_img_list = findViewById(R.id.back_img_list);
        filter_list = findViewById(R.id.filter_list);

        list_recyclerview = findViewById(R.id.list_recyclerview);
        list_recyclerview.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(ItemListActivity.this, 2);
        list_recyclerview.setLayoutManager(linearLayoutManager);
        list_recyclerview.setItemAnimator(new DefaultItemAnimator());

        HomeAdapter homeAdapter = new HomeAdapter(ItemListActivity.this);
        list_recyclerview.setAdapter(homeAdapter);

        back_img_list.setOnClickListener(this);
        filter_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_img_list:
                finish();
                break;
            case R.id.filter_list:
                startActivity(new Intent(ItemListActivity.this, FilterActivity.class));
                break;
        }

    }
}
