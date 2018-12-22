package com.example.administrator.traning.examCallApi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class ListItemProduct extends RecyclerView.Adapter <ListItemProduct.MyViewHolder> {
    private ListProduce listProduce = new ListProduce();
    private Context contextName;
    private ItemClickListener itemClickListener;
    SetOndeleteProduceListener setOndeleteProduceListener;
    SetOnEditProduceListener setOnEditProduceListener;

    public ListItemProduct(){}

    public ListItemProduct(ListProduce listProduce, Context contextName) {
        this.listProduce = listProduce;
        this.contextName = contextName;
    }

    public ListItemProduct(ListProduce listProduce, Context contextName, SetOndeleteProduceListener setOndeleteProduceListener, SetOnEditProduceListener setOnEditProduceListener) {
        this.listProduce = listProduce;
        this.contextName = contextName;
        this.setOndeleteProduceListener = setOndeleteProduceListener;
        this.setOnEditProduceListener = setOnEditProduceListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        LayoutInflater inflater  = (LayoutInflater) contextName.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list_product, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder,final int i) {
        myViewHolder.produce.setText( listProduce.getData().get(i).getProduce());
        myViewHolder.price.setText(listProduce.getData().get(i).getPrice());
        myViewHolder.produce_id.setText(listProduce.getData().get(i).getId());
        final  int pos = i;
        myViewHolder.btn_edit_prd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnEditProduceListener.onClickItemEdit(listProduce.getData().get(i));
            }
        });

        myViewHolder.btn_del_prd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOndeleteProduceListener.onClickItemDel(pos);
            }
        });
    }



    @Override
    public int getItemCount() {
        if(listProduce != null) {
            return listProduce.getData().size();
        }
        return  0;
    }

    interface ItemClickListener {
        void onClickItem(View view, int position, boolean isLongClick);

        void onClickItemData(String data);

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
         TextView produce;
         TextView price;
         TextView produce_id;
         Button btn_edit_prd;
         Button btn_del_prd;
         public MyViewHolder( View itemView) {
            super(itemView);
            produce = (TextView) itemView.findViewById(R.id.item_prd_name_api);
            price = (TextView) itemView.findViewById(R.id.item_prd_price_api);
            produce_id = (TextView) itemView.findViewById(R.id.item_prd_id_api);
            btn_del_prd = (Button)itemView.findViewById(R.id.btn_item_del);
            btn_edit_prd = (Button) itemView.findViewById(R.id.btn_item_edit);
        }


    }
    interface SetOndeleteProduceListener{
        void onClickItemDel(Object obj);
    }

    interface SetOnEditProduceListener{
        void onClickItemEdit( Object obj);
    }
}

