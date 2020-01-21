package com.example.multilayoutrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multilayoutrecyclerview.R;
import com.example.multilayoutrecyclerview.model.Group;
import com.example.multilayoutrecyclerview.model.Movie;
import com.example.multilayoutrecyclerview.model.NewPojo;
import com.example.multilayoutrecyclerview.viewholder.GroupViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Group> groups;
    private ArrayList<Movie> cover;
    private ArrayList<Movie> simple;
    private ArrayList<Movie> vertical;
    //new
    private ArrayList<NewPojo>newPojos;
    //todo 2. Create a new list with the new object

    public GroupAdapter(Context context, ArrayList<Group> groups, ArrayList<Movie> cover, ArrayList<Movie> simple, ArrayList<Movie> vertical,ArrayList<NewPojo> newPojos) {
        //todo 3. Add it to the constructor
        this.context = context;
        this.groups = groups;
        this.cover = cover;
        this.simple = simple;
        this.vertical = vertical;
        //new
        this.newPojos=newPojos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        setGroupTitle(((GroupViewHolder) holder).group_title, groups.get(position).getGroupTitle());
        setGroupButtonTitle(((GroupViewHolder) holder).view_all, groups.get(position).getGroupButtonTitle());
        setOnClickViewAll(((GroupViewHolder) holder).head_parent,groups.get(position).getGroupButtonTitle());
        setLists(((GroupViewHolder) holder).group_recycler_view,position);


    }


    @Override
    public int getItemCount() {
        return groups.size();
    }

    private void setGroupTitle(TextView textView, String text) {
        textView.setText(text);
    }

    private void setGroupButtonTitle(Button button, String text) {
        button.setText(text);
    }

    private void setOnClickViewAll(RelativeLayout button, final String groupTitle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "View all " + groupTitle, Toast.LENGTH_LONG).show();
            }
        });


    }
    private void setLists(RecyclerView recyclerView, int position) {
        //todo 4. Create a new adapter for it and display it in the list
        switch (position) {
            case 0:
                setHorizontalCoverList(recyclerView);
                break;
            case 1:
                setHorizontalSimpleList(recyclerView);
                break;
            case 2:
             ///new
                setNewName(recyclerView);
                break;

            case 3:

                setVerticalList(recyclerView);
                break;
        }
    }
/////new
    private void setNewName(RecyclerView recyclerView) {

        NewNameAdapter newNameAdapter = new NewNameAdapter(context, newPojos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(newNameAdapter);
        recyclerView.setNestedScrollingEnabled(true);

    }

    private void setVerticalList(RecyclerView recyclerView) {


        VerticalAdapter verticalAdapter = new VerticalAdapter(context, vertical);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(verticalAdapter);
        recyclerView.setNestedScrollingEnabled(true);



    }

    private void setHorizontalSimpleList(RecyclerView recyclerView) {

        MSimpleAdapter simpleAdapter = new MSimpleAdapter(context, simple);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(simpleAdapter);
        recyclerView.setNestedScrollingEnabled(true);

    }

    private void setHorizontalCoverList(RecyclerView recyclerView) {

        HorizontalCoverList horizontalCoverList = new HorizontalCoverList(context,cover);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(horizontalCoverList);
        recyclerView.setNestedScrollingEnabled(true);

    }

}
