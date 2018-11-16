package com.reviews.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.activities.GiveRatingActivity;
import com.reviews.activities.MyReviewsActivity;

import java.util.ArrayList;

public class MyReviewsAdapter extends RecyclerView.Adapter<MyReviewsAdapter.Holder> implements View.OnClickListener {
    Context context;
    ArrayList arrayList;

    public MyReviewsAdapter(MyReviewsActivity myReviewsActivity, ArrayList myRview_arrayList) {
        this.context = myReviewsActivity;
        this.arrayList = myRview_arrayList;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myrview_item_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.rview_layout.setOnClickListener(this);
        holder.txt_edit.setOnClickListener(this);
        holder.txt_delete.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rview_item_image:
                break;
            case R.id.txt_edit:
                context.startActivity(new Intent(context, GiveRatingActivity.class));
                break;
            case R.id.txt_delete:
                break;
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView rview_item_image;
        TextView txt_description, txt_edit, txt_delete, txt_date, txt_count_rview;
        LinearLayout rview_layout;

        public Holder(View itemView) {
            super(itemView);
            txt_description = itemView.findViewById(R.id.txt_description);
            txt_edit = itemView.findViewById(R.id.txt_edit);
            txt_delete = itemView.findViewById(R.id.txt_delete);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_count_rview = itemView.findViewById(R.id.txt_count_rview);
            rview_item_image = itemView.findViewById(R.id.rview_item_image);
            rview_layout = itemView.findViewById(R.id.rview_layout);

        }
    }
}
