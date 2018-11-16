package com.reviews.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reviews.R;
import com.reviews.adapters.MoreCatAdapter;
import com.reviews.models.CategoryModel;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    RecyclerView rview_categoties;
    LinearLayoutManager layoutManager;
    MoreCatAdapter moreCatAdapter;
    ArrayList<CategoryModel> cat_arrayList = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initializeUI(view);
        loadData();
        return view;
    }

    private void initializeUI(View view) {
        rview_categoties = view.findViewById(R.id.rview_categoties);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rview_categoties.setLayoutManager(layoutManager);

        moreCatAdapter = new MoreCatAdapter(getActivity(), cat_arrayList);
        rview_categoties.setAdapter(moreCatAdapter);
    }

    public void loadData() {
        int[] name = {R.string.makeup, R.string.cloths};
        int[] imageId = {R.drawable.red_makeup, R.drawable.red_clothes};

        for (int i = 0; i < imageId.length; i++) {
            CategoryModel item = new CategoryModel();
            item.setImage(imageId[i]);
            item.setName(getResources().getString(name[i]));

            cat_arrayList.add(item);
        }
    }
}
