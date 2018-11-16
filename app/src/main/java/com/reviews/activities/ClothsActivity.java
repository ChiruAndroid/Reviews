package com.reviews.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.adapters.ClothsAdapter;
import com.reviews.models.CategoryModel;

import java.util.ArrayList;

public class ClothsActivity extends AppCompatActivity {
    TextView txt_title;
    ImageView back_img;
    RecyclerView rview_cloths;
    GridLayoutManager layoutManager;
    ClothsAdapter clothsAdapter;
    ArrayList<CategoryModel> cloths_arrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloths);
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

        rview_cloths = findViewById(R.id.rview_cloths);
        layoutManager = new GridLayoutManager(ClothsActivity.this, 3, GridLayoutManager.VERTICAL, false);
        rview_cloths.setLayoutManager(layoutManager);
        loadData();
        clothsAdapter = new ClothsAdapter(ClothsActivity.this, cloths_arrayList);
        rview_cloths.setAdapter(clothsAdapter);
    }

    public void loadData() {
        int[] name = {R.string.shreath_dresses, R.string.tunic_dresses, R.string.asymetric_dresses,
                R.string.a_line_dresses, R.string.dungaree_dresses, R.string.spaghetti_dresses, R.string.shreath_dresses,
                R.string.tunic_dresses, R.string.asymetric_dresses,
                R.string.a_line_dresses, R.string.dungaree_dresses, R.string.spaghetti_dresses
        };
        int[] imageId = {R.drawable.cloth_one, R.drawable.cloth_two, R.drawable.cloth_three,
                R.drawable.cloth_four, R.drawable.cloth_five, R.drawable.cloth_six,
                R.drawable.cloth_one, R.drawable.cloth_two, R.drawable.cloth_three,
                R.drawable.cloth_four, R.drawable.cloth_five, R.drawable.cloth_six};

        for (int i = 0; i < imageId.length; i++) {
            CategoryModel item = new CategoryModel();
            item.setImage(imageId[i]);
            item.setName(getResources().getString(name[i]));
            cloths_arrayList.add(item);
        }
    }
}
