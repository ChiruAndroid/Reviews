package com.reviews.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.reviews.R;
import com.reviews.models.CategoryModel;

import java.util.ArrayList;


public class SlidingImageAdapter extends PagerAdapter {


    ViewPager viewPager;
    private ArrayList<CategoryModel> IMAGES;
    private LayoutInflater inflater;
    private Context context;

    public SlidingImageAdapter(Context context, ArrayList<CategoryModel> images_array) {
        this.context = context;
        this.IMAGES = images_array;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
//        return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.banner_slide_view, view, false);

        final ImageView image = (ImageView) imageLayout.findViewById(R.id.banner_img);
        image.setImageResource(IMAGES.get(position).getImage());
        viewPager = (ViewPager) view;
        viewPager.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

}