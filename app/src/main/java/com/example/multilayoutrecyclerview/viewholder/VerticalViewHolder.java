package com.example.multilayoutrecyclerview.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.multilayoutrecyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout vertical_parent;
    public ImageView item_vertical_picture;
    public TextView item_title;
    public TextView item_subtitle;


    public VerticalViewHolder(@NonNull View itemView) {
        super(itemView);

        vertical_parent = itemView.findViewById(R.id.vertical_parent);
        item_vertical_picture = itemView.findViewById(R.id.item_vertical_picture);
        item_title = itemView.findViewById(R.id.item_title);
        item_subtitle = itemView.findViewById(R.id.item_subtitle);


    }
}
