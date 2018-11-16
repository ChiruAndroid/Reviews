package com.reviews.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.reviews.R;
import com.reviews.activities.DetailsActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout, parent, false);
        return new HomeAdapter.HomeViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int position) {

        if (position % 2 == 0)
            holder.home_item_image.setImageDrawable(context.getDrawable(R.drawable.shirt_image));
        else
            holder.home_item_image.setImageDrawable(context.getDrawable(R.drawable.shoe_image));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open item details
                context.startActivity(new Intent(context, DetailsActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView home_item_image;

        public HomeViewHolder(View itemView) {
            super(itemView);
            home_item_image = itemView.findViewById(R.id.home_item_image);
        }
    }
}
