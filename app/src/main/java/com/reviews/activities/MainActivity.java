package com.reviews.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.fragments.AddProductFragment;
import com.reviews.fragments.CategoryFragment;
import com.reviews.fragments.HomeFragment;
import com.reviews.fragments.NotificationFragment;
import com.reviews.fragments.ProfileFragment;
import com.reviews.resideMenu.CustomResideMenu;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    ImageView main_toolbar_img_menu, menu_btmenu_home, menu_btmenu_categories,
            menu_btmenu_add, menu_btmenu_profile, menu_btmenu_notification, main_toolbar_image;
    TextView main_toolbar_title;
    CustomResideMenu resideMenu;
    RelativeLayout main_toolbar_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeValues();
    }

    private void initializeViews() {
        main_toolbar_layout = findViewById(R.id.main_toolbar_layout);
        main_toolbar_img_menu = findViewById(R.id.main_toolbar_img_menu);
        main_toolbar_title = findViewById(R.id.main_toolbar_title);
        main_toolbar_image = findViewById(R.id.main_toolbar_image);

        // Bottom navigation view
        menu_btmenu_home = findViewById(R.id.menu_btmenu_home);
        menu_btmenu_categories = findViewById(R.id.menu_btmenu_categories);
        menu_btmenu_add = findViewById(R.id.menu_btmenu_add);
        menu_btmenu_profile = findViewById(R.id.menu_btmenu_profile);
        menu_btmenu_notification = findViewById(R.id.menu_btmenu_notification);

        // Residing Menu
        setUpMenu();

        main_toolbar_img_menu.setOnClickListener(this);
        menu_btmenu_home.setOnClickListener(this);
        menu_btmenu_categories.setOnClickListener(this);
        menu_btmenu_add.setOnClickListener(this);
        menu_btmenu_profile.setOnClickListener(this);
        menu_btmenu_notification.setOnClickListener(this);
    }

    private void initializeValues() {
        if (getIntent() != null && getIntent().getStringExtra("Activity") != null) {
            String activity = getIntent().getStringExtra("Activity");
            if (activity.equalsIgnoreCase("Login")) {
                // By default set Add Product fragment
                changeFragment(new AddProductFragment());
            } else {
                // By default set home fragment
                changeFragment(new HomeFragment());
            }
        } else {
            // By default set home fragment
            changeFragment(new HomeFragment());
        }
    }

    private void setUpMenu() {
        // attach to current activity;
        resideMenu = new CustomResideMenu(this);
        resideMenu.attachToActivity(this);
        resideMenu.setScaleValue(0.6f);

        initializeMenuValues();
        resideMenu.setSwipeDirectionDisable(CustomResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(CustomResideMenu.DIRECTION_LEFT);
    }

    private void initializeMenuValues() {
        resideMenu.txt_menu_name.setText(getString(R.string.sample));
        resideMenu.txt_menu_email.setText(getString(R.string.sample_mail));

        resideMenu.txt_menu_name.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_email.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_home.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_category.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_reviews.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_share_app.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_terms.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));
        resideMenu.txt_menu_signout.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.ttf"));

        resideMenu.txt_menu_home.setOnClickListener(this);
        resideMenu.txt_menu_category.setOnClickListener(this);
        resideMenu.txt_menu_reviews.setOnClickListener(this);
        resideMenu.txt_menu_profile.setOnClickListener(this);
        resideMenu.txt_menu_share_app.setOnClickListener(this);
        resideMenu.txt_menu_terms.setOnClickListener(this);
        resideMenu.txt_menu_signout.setOnClickListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        if (v == resideMenu.txt_menu_home) {
            changeFragment(new HomeFragment());
        } else if (v == resideMenu.txt_menu_category) {
            changeFragment(new CategoryFragment());
        } else if (v == resideMenu.txt_menu_reviews) {
            if (resideMenu.isOpened()) {
                resideMenu.closeMenu();
            }
            startActivity(new Intent(MainActivity.this, MyReviewsActivity.class));
        } else if (v == resideMenu.txt_menu_profile) {
            changeFragment(new ProfileFragment());
        } else if (v == resideMenu.txt_menu_share_app) {
            // Share app link
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Reviews");
                String sAux = "\nHey there,\n \n Check out the Reviews app. Download it now.\n\n";
                sAux = sAux + "https://www.google.com \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }
        } else if (v == resideMenu.txt_menu_terms) {
            // Open terms and conditions
        } else if (v == resideMenu.txt_menu_signout) {
            if (resideMenu.isOpened()) {
                resideMenu.closeMenu();
            }
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            loginIntent.putExtra("Activity", "Signout");
            startActivity(loginIntent);
            finish();
        } else if (v.getId() == R.id.main_toolbar_img_menu) {
            if (resideMenu.isOpened()) {
                resideMenu.closeMenu();
            } else {
                resideMenu.openMenu(CustomResideMenu.DIRECTION_LEFT);
            }
        } else if (v.getId() == R.id.menu_btmenu_home) {
            changeFragment(new HomeFragment());
        } else if (v.getId() == R.id.menu_btmenu_categories) {
            changeFragment(new CategoryFragment());
        } else if (v.getId() == R.id.menu_btmenu_add) {
            if (resideMenu.isOpened()) {
                resideMenu.closeMenu();
            }
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            loginIntent.putExtra("Activity", "Login");
            startActivity(loginIntent);
            finish();
        } else if (v.getId() == R.id.menu_btmenu_profile) {
            changeFragment(new ProfileFragment());
        } else if (v.getId() == R.id.menu_btmenu_notification) {
            changeFragment(new NotificationFragment());
        }
    }

    public void changeFragment(Fragment targetFragment) {
        resideMenu.clearIgnoredViewList();
        if (resideMenu.isOpened()) {
            resideMenu.closeMenu();
            resideMenu.setSwipeDirectionDisable(CustomResideMenu.DIRECTION_LEFT);
        }

        setHomeScreenViews(targetFragment);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @SuppressLint("NewApi")
    private void setHomeScreenViews(Fragment targetFragment) {
        // Set toolbar
        if (targetFragment instanceof HomeFragment) {
            main_toolbar_layout.setVisibility(View.VISIBLE);
            main_toolbar_title.setVisibility(View.GONE);
            main_toolbar_image.setVisibility(View.VISIBLE);
        } else {
            main_toolbar_layout.setVisibility(View.VISIBLE);
            main_toolbar_title.setVisibility(View.VISIBLE);
            main_toolbar_image.setVisibility(View.GONE);
        }

        if (targetFragment instanceof NotificationFragment) {
            main_toolbar_title.setText(getResources().getString(R.string.notification));
        } else if (targetFragment instanceof AddProductFragment) {
            main_toolbar_title.setText(getResources().getString(R.string.add_product));
        } else if (targetFragment instanceof ProfileFragment) {
            main_toolbar_title.setText(getResources().getString(R.string.my_profile));
            main_toolbar_layout.setVisibility(View.GONE);
        } else if (targetFragment instanceof CategoryFragment) {
            main_toolbar_title.setText(getResources().getString(R.string.category));
        }

        // Set bottom views
        if (targetFragment instanceof HomeFragment) {
            menu_btmenu_home.setImageDrawable(getDrawable(R.drawable.red_home));
            menu_btmenu_categories.setImageDrawable(getDrawable(R.drawable.grey_category));
            menu_btmenu_profile.setImageDrawable(getDrawable(R.drawable.grey_profile));
            menu_btmenu_notification.setImageDrawable(getDrawable(R.drawable.grey_notification));
        } else if (targetFragment instanceof NotificationFragment) {
            menu_btmenu_home.setImageDrawable(getDrawable(R.drawable.grey_home));
            menu_btmenu_categories.setImageDrawable(getDrawable(R.drawable.grey_category));
            menu_btmenu_profile.setImageDrawable(getDrawable(R.drawable.grey_profile));
            menu_btmenu_notification.setImageDrawable(getDrawable(R.drawable.red_notification));
        } else if (targetFragment instanceof AddProductFragment) {
            menu_btmenu_home.setImageDrawable(getDrawable(R.drawable.grey_home));
            menu_btmenu_categories.setImageDrawable(getDrawable(R.drawable.grey_category));
            menu_btmenu_profile.setImageDrawable(getDrawable(R.drawable.grey_profile));
            menu_btmenu_notification.setImageDrawable(getDrawable(R.drawable.grey_notification));
        } else if (targetFragment instanceof ProfileFragment) {
            menu_btmenu_home.setImageDrawable(getDrawable(R.drawable.grey_home));
            menu_btmenu_categories.setImageDrawable(getDrawable(R.drawable.grey_category));
            menu_btmenu_profile.setImageDrawable(getDrawable(R.drawable.red_profile));
            menu_btmenu_notification.setImageDrawable(getDrawable(R.drawable.grey_notification));
        } else if (targetFragment instanceof CategoryFragment) {
            menu_btmenu_home.setImageDrawable(getDrawable(R.drawable.grey_home));
            menu_btmenu_categories.setImageDrawable(getDrawable(R.drawable.red_categories));
            menu_btmenu_profile.setImageDrawable(getDrawable(R.drawable.grey_profile));
            menu_btmenu_notification.setImageDrawable(getDrawable(R.drawable.grey_notification));
        }
    }
}
