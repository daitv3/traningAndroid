package com.example.administrator.traning.salon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListItemServiceSalon extends RecyclerView.Adapter<ListItemServiceSalon.MyViewHolder>{
    Relationships relationships;
    Context context;

    public ListItemServiceSalon(Relationships relationships, Context context) {
        this.relationships = relationships;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        LayoutInflater inflater  = (LayoutInflater) contextName.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_service_salon, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        myViewHolder.spinner.set
        //myViewHolder.item_name.setText(relationships.getServices().get(i).getName());
        ArrayList<String> list = new ArrayList<String>();
        list.add(relationships.getServices().get(i).getName());
        list.add(relationships.getServices().get(i).getPrice());
        list.add(relationships.getServices().get(i).getDescription());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        myViewHolder.spinner.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if(relationships != null) {
            return relationships.getServices().size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        Spinner spinner;
        Button item_name;


        public MyViewHolder( View itemView) {
            super(itemView);
         //  spinner = (Spinner) itemView.findViewById(R.id.item_spinner_service_salon);
        //   item_name = (Button) itemView.findViewById(R.id.item_name_service_salon);
           spinner = (Spinner) itemView.findViewById(R.id.spiner_service);
        }


    }
}
