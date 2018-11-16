package com.reviews.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.adapters.MyReviewsAdapter;

import java.util.ArrayList;

public class MyReviewsActivity extends AppCompatActivity {

    TextView txt_title;
    ImageView back_img;
    RecyclerView rview_myRviews;
    LinearLayoutManager layoutManager;
    MyReviewsAdapter myReviewsAdapter;
    ArrayList myRview_arrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reviews);
        initializeUI();
    }

    private void initializeUI() {

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rview_myRviews = findViewById(R.id.rview_myRviews);
        layoutManager = new LinearLayoutManager(MyReviewsActivity.this, LinearLayoutManager.VERTICAL, false);
        rview_myRviews.setLayoutManager(layoutManager);
        myReviewsAdapter = new MyReviewsAdapter(MyReviewsActivity.this, myRview_arrayList);
        rview_myRviews.setAdapter(myReviewsAdapter);
    }
}
