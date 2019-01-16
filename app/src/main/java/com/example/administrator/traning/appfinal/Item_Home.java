package com.example.administrator.traning.appfinal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.traning.R;

public class Item_Home  extends RecyclerView.Adapter<Item_Home.MyViewHolder>{


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        LayoutInflater inflater  = (LayoutInflater) contextName.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_fn_home, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    interface OnClickItemFn{
        void onClickItem();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{



        public MyViewHolder( View itemView) {
            super(itemView);



        }


    }
}
