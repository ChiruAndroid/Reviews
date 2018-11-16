package com.reviews.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.adapters.SlidingImageAdapter;
import com.reviews.models.CategoryModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DetailsActivity extends AppCompatActivity {

    int NUM_PAGES = 0;
    ViewPager viewPager;
    ImageView[] dots;
    int dotcount;
    SlidingImageAdapter slidingImageAdapter;
    LinearLayout layoutIndicators;
    ArrayList<CategoryModel> images_array = new ArrayList<>();
    TextView details_add_review_btn, all_reviews_txt;
    ImageView back_img_details;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initializeUI();
        loadData();
        slidingImageAdapter = new SlidingImageAdapter(DetailsActivity.this, images_array);
        viewPager.setAdapter(slidingImageAdapter);
        home_banner_Ads();
    }

    private void initializeUI() {
        viewPager = findViewById(R.id.viewPager);
        layoutIndicators = findViewById(R.id.home_indicators);
        back_img_details = findViewById(R.id.back_img_details);
        all_reviews_txt = findViewById(R.id.all_reviews_txt);
        details_add_review_btn = findViewById(R.id.details_add_review_btn);
        details_add_review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this, GiveRatingActivity.class));
            }
        });

        back_img_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        all_reviews_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this, MyReviewsActivity.class));
            }
        });

    }

    public void loadData() {
        int[] imageId = {R.drawable.grey_shirt_image, R.drawable.grey_shirt_image, R.drawable.grey_shirt_image,
                R.drawable.grey_shirt_image, R.drawable.grey_shirt_image};

        for (int i = 0; i < imageId.length; i++) {
            CategoryModel item = new CategoryModel();
            item.setImage(imageId[i]);
            images_array.add(item);
        }
    }

    public void home_banner_Ads() {
        dotcount = slidingImageAdapter.getCount();
        dots = new ImageView[dotcount];

        for (int i = 0; i < dotcount; i++) {
            dots[i] = new ImageView(DetailsActivity.this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.unselecetd_circle_indicater));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(10, 0, 10, 0);
            layoutIndicators.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_dot_drawable));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotcount; i++) {
                    // dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.unselect_dot_drwable));
                    dots[i].setImageDrawable(getResources().getDrawable(R.drawable.unselecetd_circle_indicater));
                }
                dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selected_dot_drawable));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        NUM_PAGES = images_array.size();

        /*AutoScroll*/
       /* final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);*/
    }
}
