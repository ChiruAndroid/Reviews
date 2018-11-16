package com.reviews.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.reviews.R;
import com.reviews.activities.MainActivity;

public class AddProductFragment extends Fragment {

    public static boolean isAddProduct = false;
    Button add_product_review;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        add_product_review = view.findViewById(R.id.add_product_review);

        add_product_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAddProduct = true;
                ((MainActivity) getActivity()).changeFragment(new HomeFragment());
            }
        });
    }
}
