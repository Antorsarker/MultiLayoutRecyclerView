package com.example.multilayoutrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multilayoutrecyclerview.R;
import com.example.multilayoutrecyclerview.model.Movie;
import com.example.multilayoutrecyclerview.model.NewPojo;
import com.example.multilayoutrecyclerview.viewholder.NewNameViewHolder;
import com.example.multilayoutrecyclerview.viewholder.VerticalViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewNameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<NewPojo> newPojos;

    public NewNameAdapter(Context context, ArrayList<NewPojo> newPojos) {
        this.context = context;
        this.newPojos = newPojos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

   View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);
        return new NewNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        setTitle(((NewNameViewHolder)holder).new_item_title,newPojos.get(position).getTitle());
        setSubtitle(((NewNameViewHolder)holder).new_item_subtitle,newPojos.get(position).getSubTitle());
        setOnClick(((NewNameViewHolder) holder).new_item_parent,position);

    }

    @Override
    public int getItemCount() {
        return newPojos.size();
    }

    private void setTitle(TextView textView, String text) {
        textView.setText(text);
    }

    private void setSubtitle(TextView textView, String text) {
        textView.setText(text);
    }

    private void setOnClick(RelativeLayout button, final int position) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click: " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}
