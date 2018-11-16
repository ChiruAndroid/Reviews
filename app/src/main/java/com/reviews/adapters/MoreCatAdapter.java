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
import com.reviews.activities.ClothsActivity;
import com.reviews.models.CategoryModel;

import java.util.ArrayList;

public class MoreCatAdapter extends RecyclerView.Adapter<MoreCatAdapter.Holder> {
    Context context;
    ArrayList<CategoryModel> arrayList;

    public MoreCatAdapter(Context context, ArrayList<CategoryModel> cat_arrayList) {
        this.context = context;
        this.arrayList = cat_arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.more_cat_item_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        if (position % 2 == 0) {
            holder.cat_item_img.setImageResource(R.drawable.red_makeup);
        } else {
            holder.cat_item_img.setImageResource(R.drawable.red_clothes);
        }

        holder.cat_item_name.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ClothsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView cat_item_img;
        TextView cat_item_name;

        public Holder(View itemView) {
            super(itemView);
            cat_item_img = itemView.findViewById(R.id.cat_item_img);
            cat_item_name = itemView.findViewById(R.id.cat_item_name);
        }
    }
}
