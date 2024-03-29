package com.reviews.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reviews.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.Notifi_Holder> {

    Context context;
    ArrayList notify_list;

    public NotificationAdapter(Context context, ArrayList notify_arrayList) {
        this.context = context;
        this.notify_list = notify_arrayList;
    }


    @NonNull
    @Override
    public Notifi_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notify_item_view, parent, false);

        return new Notifi_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Notifi_Holder holder, int position) {
        notify_list = new ArrayList();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Notifi_Holder extends RecyclerView.ViewHolder {
        LinearLayout cardView;
        TextView txt_msg, txt_time;

        public Notifi_Holder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.notify_layout);
            txt_msg = itemView.findViewById(R.id.text_message);
            txt_time = itemView.findViewById(R.id.time);
        }
    }
}