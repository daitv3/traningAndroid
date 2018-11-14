package com.example.administrator.traning.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListNameItem extends BaseAdapter{
    private Context contextName;
    private ArrayList<String> listdata ;

    public ListNameItem(Context contextName, ArrayList<String> listdata) {
        this.contextName = contextName;
        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //khoi tao doi tuong view lay tu layout
        LayoutInflater inflater = (LayoutInflater) contextName.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.item_list_view_demo,parent,false);
        TextView txtView = (TextView) rowView.findViewById(R.id.tv_hello);
        txtView.setText(listdata.get(position));
        return rowView;
    }
}
