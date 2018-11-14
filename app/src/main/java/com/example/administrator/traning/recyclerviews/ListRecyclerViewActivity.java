package com.example.administrator.traning.recyclerviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListRecyclerViewActivity extends Activity implements ListItemRecyclerView.ItemClickListener {
    ArrayList<String> listName;
    RecyclerView recyclerView;
    ListItemRecyclerView listItemRecyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_recycker_view);
        listName = new ArrayList<String>();
        listName.add("abc0");
        listName.add("abc1");
        listName.add("abc2");
        listName.add("abc3");
        recyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        listItemRecyclerView = new ListItemRecyclerView(listName,this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listItemRecyclerView);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onClickItem(View view, int position, boolean isLongClick) {

    }

    @Override
    public void onClickItemData(String data) {
        Intent intent = new Intent(this,AddNewItem.class);
        intent.putExtra("name", data);
        startActivity(intent);
    }
}
