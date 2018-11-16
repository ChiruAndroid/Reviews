package com.reviews.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reviews.R;
import com.reviews.adapters.NotificationAdapter;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    RecyclerView rview_notofications;
    LinearLayoutManager layoutManager;
    NotificationAdapter notificationAdapter;
    ArrayList notify_arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        initializeUI(view);
        return view;
    }

    private void initializeUI(View view) {
        rview_notofications = view.findViewById(R.id.rview_notofications);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rview_notofications.setLayoutManager(layoutManager);

        notify_arrayList = new ArrayList();
        notificationAdapter = new NotificationAdapter(getActivity(), notify_arrayList);
        rview_notofications.setAdapter(notificationAdapter);
    }

}
