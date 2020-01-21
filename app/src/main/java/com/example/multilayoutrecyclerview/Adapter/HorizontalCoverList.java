package com.example.multilayoutrecyclerview.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.multilayoutrecyclerview.R;
import com.example.multilayoutrecyclerview.model.Movie;
import com.example.multilayoutrecyclerview.viewholder.CoverViewHolder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalCoverList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;

    public HorizontalCoverList(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cover_item,parent,false);

        return new CoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        setImage(((CoverViewHolder) holder).item_cover_picture,movies.get(position).getMoviePictureURL());
        setOnClick(((CoverViewHolder) holder).cover_parent,position);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private void setImage(final ImageView imageView, String imageURL) {

        Picasso.get().load(imageURL).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                imageView.setBackgroundResource(R.drawable.ic_launcher_background);
            }
        });



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
