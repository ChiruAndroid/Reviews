package com.reviews.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.reviews.R;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_apply;
    RadioButton rb_bad, rb_normal, rb_good, rb_hign_to_low, rb_low_to_high;
    ImageView back_img;
    TextView toolbar_title, toolbar_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        initializeUI();
    }

    private void initializeUI() {
        //Button
        btn_apply = findViewById(R.id.btn_apply);
        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_reset = findViewById(R.id.toolbar_reset);

        //RadioButton
        rb_low_to_high = findViewById(R.id.rb_low_to_high);
        rb_hign_to_low = findViewById(R.id.rb_hign_to_low);
        rb_good = findViewById(R.id.rb_good);
        rb_normal = findViewById(R.id.rb_normal);
        rb_bad = findViewById(R.id.rb_bad);

        //ImageView
        back_img = findViewById(R.id.back_img);

        btn_apply.setOnClickListener(this);
        back_img.setOnClickListener(this);
        toolbar_reset.setOnClickListener(this);
        rb_low_to_high.setOnClickListener(this);
        rb_hign_to_low.setOnClickListener(this);
        rb_good.setOnClickListener(this);
        rb_normal.setOnClickListener(this);
        rb_bad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_apply:
                finish();
                break;
            case R.id.back_img:
                finish();
                break;
            case R.id.toolbar_reset:
                rb_low_to_high.setChecked(false);
                rb_hign_to_low.setChecked(false);
                rb_good.setChecked(false);
                rb_normal.setChecked(false);
                rb_bad.setChecked(false);
                break;
            case R.id.rb_low_to_high:
                rb_low_to_high.setChecked(true);
                rb_hign_to_low.setChecked(false);
                break;
            case R.id.rb_hign_to_low:
                rb_hign_to_low.setChecked(true);
                rb_low_to_high.setChecked(false);
                break;
            case R.id.rb_good:
                rb_good.setChecked(true);
                rb_normal.setChecked(false);
                rb_bad.setChecked(false);
                break;
            case R.id.rb_normal:
                rb_good.setChecked(false);
                rb_normal.setChecked(true);
                rb_bad.setChecked(false);
                break;
            case R.id.rb_bad:
                rb_good.setChecked(false);
                rb_normal.setChecked(false);
                rb_bad.setChecked(true);
                break;

        }
    }
}
