package com.example.administrator.traning.kiemtra;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListItemSamPhamAdapter extends RecyclerView.Adapter<ListItemSamPhamAdapter.SanPhamAdapter>{

    ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
    Context contextName;
    SetOndeleteSanPhamListener setOndeleteSanPhamListener;
    SetOnEditSanPhamListener setOnEditSanPhamListener;

    public ListItemSamPhamAdapter(ArrayList<SanPham> listSanPham, Context contextName) {
        this.listSanPham = listSanPham;
        this.contextName = contextName;
    }

    public ListItemSamPhamAdapter(ArrayList<SanPham> listSanPham, Context contextName, SetOndeleteSanPhamListener setOndeleteSanPhamListener) {
        this.listSanPham = listSanPham;
        this.contextName = contextName;
        this.setOndeleteSanPhamListener = setOndeleteSanPhamListener;
    }

    public ListItemSamPhamAdapter(ArrayList<SanPham> listSanPham, Context contextName, SetOnEditSanPhamListener setOnEditSanPhamListener) {
        this.listSanPham = listSanPham;
        this.contextName = contextName;
        this.setOnEditSanPhamListener = setOnEditSanPhamListener;
    }

    public ListItemSamPhamAdapter(ArrayList<SanPham> listSanPham, Context contextName, SetOndeleteSanPhamListener setOndeleteSanPhamListener, SetOnEditSanPhamListener setOnEditSanPhamListener) {
        this.listSanPham = listSanPham;
        this.contextName = contextName;
        this.setOndeleteSanPhamListener = setOndeleteSanPhamListener;
        this.setOnEditSanPhamListener = setOnEditSanPhamListener;
    }

    @NonNull
    @Override
    public SanPhamAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_list_san_pham, viewGroup, false);
        SanPhamAdapter viewHolder = new SanPhamAdapter(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter sanPham, int i) {
        sanPham.lbPrdName.setText(listSanPham.get(i).getProductName());
        sanPham.lbPrdPrice.setText(listSanPham.get(i).getProductPrice());
        final int pos = i;
        sanPham.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOndeleteSanPhamListener.onClickItemDel(pos);
            }
        });

        sanPham.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham1 = new SanPham(listSanPham.get(pos).getProductName(),listSanPham.get(pos).getProductPrice());
                setOnEditSanPhamListener.onClickItemEdit(sanPham1, pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSanPham.size();
    }

    class SanPhamAdapter extends RecyclerView.ViewHolder {
        public TextView lbPrdName;
        public TextView lbPrdPrice;
        public Button imgDelete;
        public  Button imgEdit;


        public SanPhamAdapter(@NonNull View itemView) {
            super(itemView);

            lbPrdName = (TextView) itemView.findViewById(R.id.item_prd_name);
            lbPrdPrice = (TextView) itemView.findViewById(R.id.item_prd_price);
            imgDelete = (Button) itemView.findViewById(R.id.item_del);
            imgEdit = (Button) itemView.findViewById(R.id.item_edit);
        }
    }

    interface SetOndeleteSanPhamListener{
        void onClickItemDel(int i);
    }

    interface SetOnEditSanPhamListener{
        void onClickItemEdit(SanPham view, int i);
    }
}




