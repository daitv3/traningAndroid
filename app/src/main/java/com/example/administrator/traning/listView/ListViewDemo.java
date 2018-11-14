package com.example.administrator.traning.listView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListViewDemo extends Activity{
    ListNameItem nameItemAdapter;
    ArrayList<String> a;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_list_view_demo);
        ListView listView = (ListView) findViewById(R.id.list_view_hellos);
        a = getDataItem();
         nameItemAdapter = new ListNameItem(this,a);

        listView.setAdapter(nameItemAdapter);
        a.add("1111");
        nameItemAdapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewDemo.this,ContentViewDemo.class);
                intent.putExtra("text",getDataItem().get(position));
                startActivityForResult(intent,1);


            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 1){
            String q = data.getStringExtra("x");
            a.set(1,q);
            String a = getDataItem().get(1);
            Log.d("qqq", "onActivityResult: "+a);
            nameItemAdapter.notifyDataSetChanged();
        }

    }

    public ArrayList<String> getDataItem(){
        ArrayList<String> listData = new ArrayList<String>();
        listData.add("xxx");
        listData.add("xxx0");
        listData.add("xxx1");
        listData.add("xxx2");
        //listData.add("xxx3");
        return listData;

    }

 }
