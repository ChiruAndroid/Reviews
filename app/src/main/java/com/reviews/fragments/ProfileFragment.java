package com.reviews.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.activities.MainActivity;
import com.reviews.activities.MyReviewsActivity;

public class ProfileFragment extends Fragment {

    ImageView profile_img, back_img;
    TextView profile_name, profile_email, txt_title, txt_save;
    LinearLayout my_review_layout;
    EditText et_fullname, et_email, et_password, et_conf_pwd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_my_profile, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        //ImageView
        profile_img = view.findViewById(R.id.profile_img);
        back_img = view.findViewById(R.id.back_img);
        //TextView
        profile_name = view.findViewById(R.id.profile_name);
        profile_email = view.findViewById(R.id.profile_email);
        txt_title = view.findViewById(R.id.txt_title);
        txt_save = view.findViewById(R.id.txt_save);
        //EditText
        et_fullname = view.findViewById(R.id.et_fullname);
        et_email = view.findViewById(R.id.et_email);
        et_password = view.findViewById(R.id.et_password);
        et_conf_pwd = view.findViewById(R.id.et_conf_pwd);
        //LinearLayout
        my_review_layout = view.findViewById(R.id.my_review_layout);

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new HomeFragment());
            }
        });
        my_review_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyReviewsActivity.class));
            }
        });
        txt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new HomeFragment());
            }
        });
    }
}
