package com.example.multilayoutrecyclerview.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.multilayoutrecyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CoverViewHolder extends RecyclerView.ViewHolder {

    public ImageView item_cover_picture;
    public RelativeLayout cover_parent;


    public CoverViewHolder(@NonNull View itemView) {
        super(itemView);

        item_cover_picture = itemView.findViewById(R.id.item_cover_picture);
        cover_parent = itemView.findViewById(R.id.cover_parent);


    }
}
