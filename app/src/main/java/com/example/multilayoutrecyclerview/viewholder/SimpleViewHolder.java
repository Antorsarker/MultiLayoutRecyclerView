package com.example.multilayoutrecyclerview.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.multilayoutrecyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    public ImageView item_simple_picture;
    public RelativeLayout simple_parent;

    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);

        item_simple_picture = itemView.findViewById(R.id.item_simple_picture);
        simple_parent = itemView.findViewById(R.id.simple_parent);


    }
}
