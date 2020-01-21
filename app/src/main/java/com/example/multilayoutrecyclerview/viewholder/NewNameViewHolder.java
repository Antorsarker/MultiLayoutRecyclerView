package com.example.multilayoutrecyclerview.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.multilayoutrecyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewNameViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout new_item_parent;
    public TextView new_item_title;
    public TextView new_item_subtitle;

    public NewNameViewHolder(@NonNull View itemView) {
        super(itemView);


        new_item_parent = itemView.findViewById(R.id.new_item_parent);
        new_item_title = itemView.findViewById(R.id.item_title);
        new_item_subtitle = itemView.findViewById(R.id.item_subtitle);

    }
}
