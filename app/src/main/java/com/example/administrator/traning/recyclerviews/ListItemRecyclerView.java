package com.example.administrator.traning.recyclerviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListItemRecyclerView extends RecyclerView.Adapter<ListItemRecyclerView.MyViewHolder> {

    private ArrayList<String> listName;
    private Context contextName;
    private ItemClickListener itemClickListener;
    public ListItemRecyclerView(ArrayList<String> listName, Context contextName) {
        this.listName = listName;
        this.contextName = contextName;
    }

    public ListItemRecyclerView() {

    }

    public ListItemRecyclerView(ArrayList<String> listName, ItemClickListener itemClickListener, Context contextName) {
        this.listName = listName;
        this.itemClickListener = itemClickListener;
        this.contextName = contextName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        LayoutInflater inflater  = (LayoutInflater) contextName.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list_view_demo, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
       final String data= listName.get(i);
       myViewHolder.name.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               itemClickListener.onClickItemData(data);
           }
       });
        myViewHolder.name.setText(listName.get(i));

    }

    @Override
    public int getItemCount() {
        return listName.size();
    }


     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView name;
        private LinearLayout linearLayout;

        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_hello);

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }


    }

     interface ItemClickListener {
        void onClickItem(View view, int position, boolean isLongClick);

        void onClickItemData(String data);

    }


}