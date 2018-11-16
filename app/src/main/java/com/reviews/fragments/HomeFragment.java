package com.reviews.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.reviews.R;
import com.reviews.activities.ItemListActivity;
import com.reviews.activities.MainActivity;
import com.reviews.adapters.HomeAdapter;


public class HomeFragment extends Fragment {

    RecyclerView home_recyclerview;
    LinearLayout home_more_layout, home_souq_layout, home_letstango_layout,
            home_mumz_layout, home_carrefour_layout, home_wysa_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        home_recyclerview = view.findViewById(R.id.home_recyclerview);
        home_recyclerview.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        home_recyclerview.setLayoutManager(linearLayoutManager);
        home_recyclerview.setItemAnimator(new DefaultItemAnimator());

        HomeAdapter homeAdapter = new HomeAdapter(getActivity());
        home_recyclerview.setAdapter(homeAdapter);

        home_more_layout = view.findViewById(R.id.home_more_layout);
        home_souq_layout = view.findViewById(R.id.home_souq_layout);
        home_letstango_layout = view.findViewById(R.id.home_letstango_layout);
        home_mumz_layout = view.findViewById(R.id.home_mumz_layout);
        home_carrefour_layout = view.findViewById(R.id.home_carrefour_layout);
        home_wysa_layout = view.findViewById(R.id.home_wysa_layout);

        // Click actions
        home_more_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new CategoryFragment());
            }
        });

        home_souq_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ItemListActivity.class));
            }
        });


        home_letstango_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ItemListActivity.class));
            }
        });

        home_mumz_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ItemListActivity.class));
            }
        });

        home_carrefour_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ItemListActivity.class));
            }
        });

        home_wysa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ItemListActivity.class));
            }
        });
    }
}
