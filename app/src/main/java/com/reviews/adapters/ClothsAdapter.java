package com.reviews.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reviews.R;
import com.reviews.activities.DetailsActivity;
import com.reviews.models.CategoryModel;

import java.util.ArrayList;

public class ClothsAdapter extends RecyclerView.Adapter<ClothsAdapter.Holder> {
    Context context;
    ArrayList<CategoryModel> arrayList;

    public ClothsAdapter(Context context, ArrayList<CategoryModel> cloths_arrayList) {
        this.context = context;
        this.arrayList = cloths_arrayList;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cloth_item_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.cloth__item_name.setText(arrayList.get(position).getName());
        holder.cloth_item_image.setImageResource(arrayList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView cloth_item_image;
        TextView cloth__item_name;

        public Holder(View itemView) {
            super(itemView);
            cloth_item_image = itemView.findViewById(R.id.cloth_item_image);
            cloth__item_name = itemView.findViewById(R.id.cloth__item_name);
        }
    }
}
