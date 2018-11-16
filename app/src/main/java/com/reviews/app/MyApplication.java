package com.reviews.app;

import android.app.Application;

import com.reviews.utilities.TypefaceUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Poppins-Regular.ttf");
    }
}
