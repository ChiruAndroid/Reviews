package com.reviews.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.reviews.R;

public class GiveRatingActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back_img_rating, overall_one, overall_two, overall_three, overall_four, overall_five, benefit_one, benefit_two, benefit_three,
            benefit_four, benefit_five;
    ImageView quality_one, quality_two, quality_three, quality_four, quality_five, price_one, price_two, price_three, price_four, price_five;
    TextView overall_txt, quality_txt, price_txt, benefit_txt;
    EditText rating_edit_txt;
    Button btn_add_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_rating);

        initializeView();
    }

    private void initializeView() {
        back_img_rating = findViewById(R.id.back_img_rating);
        btn_add_review = findViewById(R.id.btn_add_review);
        overall_one = findViewById(R.id.overall_one);
        overall_two = findViewById(R.id.overall_two);
        overall_three = findViewById(R.id.overall_three);
        overall_four = findViewById(R.id.overall_four);
        overall_txt = findViewById(R.id.overall_txt);
        overall_five = findViewById(R.id.overall_five);
        quality_one = findViewById(R.id.quality_one);
        quality_two = findViewById(R.id.quality_two);
        quality_three = findViewById(R.id.quality_three);
        quality_four = findViewById(R.id.quality_four);
        quality_five = findViewById(R.id.quality_five);
        quality_txt = findViewById(R.id.quality_txt);
        price_one = findViewById(R.id.price_one);
        price_two = findViewById(R.id.price_two);
        price_three = findViewById(R.id.price_three);
        price_four = findViewById(R.id.price_four);
        price_five = findViewById(R.id.price_five);
        price_txt = findViewById(R.id.price_txt);
        benefit_one = findViewById(R.id.benefit_one);
        benefit_two = findViewById(R.id.benefit_two);
        benefit_three = findViewById(R.id.benefit_three);
        benefit_four = findViewById(R.id.benefit_four);
        benefit_five = findViewById(R.id.benefit_five);
        benefit_txt = findViewById(R.id.benefit_txt);
        rating_edit_txt = findViewById(R.id.rating_edit_txt);
        rating_edit_txt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(160)});

        back_img_rating.setOnClickListener(this);
        btn_add_review.setOnClickListener(this);
        overall_one.setOnClickListener(this);
        overall_two.setOnClickListener(this);
        overall_three.setOnClickListener(this);
        overall_four.setOnClickListener(this);
        overall_five.setOnClickListener(this);
        quality_one.setOnClickListener(this);
        quality_two.setOnClickListener(this);
        quality_three.setOnClickListener(this);
        quality_four.setOnClickListener(this);
        quality_five.setOnClickListener(this);
        price_one.setOnClickListener(this);
        price_two.setOnClickListener(this);
        price_three.setOnClickListener(this);
        price_four.setOnClickListener(this);
        price_five.setOnClickListener(this);
        benefit_one.setOnClickListener(this);
        benefit_two.setOnClickListener(this);
        benefit_three.setOnClickListener(this);
        benefit_four.setOnClickListener(this);
        benefit_five.setOnClickListener(this);
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_review:
            case R.id.back_img_rating:
                finish();
                break;
            case R.id.overall_one:
                overall_txt.setText("Average");
                overall_one.setImageDrawable(getDrawable(R.drawable.star_one_fill));
                overall_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                overall_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                overall_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                overall_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.overall_two:
                overall_txt.setText("Good");
                overall_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                overall_two.setImageDrawable(getDrawable(R.drawable.star_two_fill));
                overall_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                overall_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                overall_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.overall_three:
                overall_txt.setText("Very Good");
                overall_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                overall_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                overall_three.setImageDrawable(getDrawable(R.drawable.star_three_fill));
                overall_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                overall_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.overall_four:
                overall_txt.setText("Better");
                overall_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                overall_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                overall_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                overall_four.setImageDrawable(getDrawable(R.drawable.star_four_fill));
                overall_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.overall_five:
                overall_txt.setText("Excellent");
                overall_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                overall_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                overall_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                overall_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                overall_five.setImageDrawable(getDrawable(R.drawable.star_five_fill));
                break;
            case R.id.quality_one:
                quality_txt.setText("Average");
                quality_one.setImageDrawable(getDrawable(R.drawable.star_one_fill));
                quality_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                quality_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                quality_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                quality_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.quality_two:
                quality_txt.setText("Good");
                quality_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                quality_two.setImageDrawable(getDrawable(R.drawable.star_two_fill));
                quality_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                quality_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                quality_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.quality_three:
                quality_txt.setText("Very Good");
                quality_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                quality_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                quality_three.setImageDrawable(getDrawable(R.drawable.star_three_fill));
                quality_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                quality_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.quality_four:
                quality_txt.setText("Better");
                quality_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                quality_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                quality_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                quality_four.setImageDrawable(getDrawable(R.drawable.star_four_fill));
                quality_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.quality_five:
                quality_txt.setText("Excellent");
                quality_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                quality_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                quality_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                quality_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                quality_five.setImageDrawable(getDrawable(R.drawable.star_five_fill));
                break;
            case R.id.price_one:
                price_txt.setText("Average");
                price_one.setImageDrawable(getDrawable(R.drawable.star_one_fill));
                price_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                price_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                price_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                price_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.price_two:
                price_txt.setText("Good");
                price_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                price_two.setImageDrawable(getDrawable(R.drawable.star_two_fill));
                price_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                price_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                price_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.price_three:
                price_txt.setText("Very Good");
                price_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                price_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                price_three.setImageDrawable(getDrawable(R.drawable.star_three_fill));
                price_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                price_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.price_four:
                price_txt.setText("Better");
                price_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                price_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                price_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                price_four.setImageDrawable(getDrawable(R.drawable.star_four_fill));
                price_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.price_five:
                price_txt.setText("Excellent");
                price_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                price_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                price_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                price_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                price_five.setImageDrawable(getDrawable(R.drawable.star_five_fill));
                break;
            case R.id.benefit_one:
                benefit_txt.setText("Average");
                benefit_one.setImageDrawable(getDrawable(R.drawable.star_one_fill));
                benefit_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                benefit_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                benefit_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                benefit_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.benefit_two:
                benefit_txt.setText("Good");
                benefit_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                benefit_two.setImageDrawable(getDrawable(R.drawable.star_two_fill));
                benefit_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                benefit_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                benefit_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.benefit_three:
                benefit_txt.setText("Very Good");
                benefit_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                benefit_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                benefit_three.setImageDrawable(getDrawable(R.drawable.star_three_fill));
                benefit_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                benefit_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.benefit_four:
                benefit_txt.setText("Better");
                benefit_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                benefit_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                benefit_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                benefit_four.setImageDrawable(getDrawable(R.drawable.star_four_fill));
                benefit_five.setImageDrawable(getDrawable(R.drawable.star_five_unfill));
                break;
            case R.id.benefit_five:
                benefit_txt.setText("Excellent");
                benefit_one.setImageDrawable(getDrawable(R.drawable.star_one_unfill));
                benefit_two.setImageDrawable(getDrawable(R.drawable.star_two_unfill));
                benefit_three.setImageDrawable(getDrawable(R.drawable.star_three_unfill));
                benefit_four.setImageDrawable(getDrawable(R.drawable.star_four_unfill));
                benefit_five.setImageDrawable(getDrawable(R.drawable.star_five_fill));
                break;
        }
    }
}
