package com.example.administrator.traning.kiemtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.traning.R;

import java.util.ArrayList;

public class ListSanPhamActivity extends Activity implements ListItemSamPhamAdapter.SetOnEditSanPhamListener, ListItemSamPhamAdapter.SetOndeleteSanPhamListener{
    EditText txtPrdName;
    EditText txtPrdPrice ;
    Button btnThemPrd;
    ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
    RecyclerView recyclerView;
    ListItemSamPhamAdapter listItemSamPhamAdapter;
    static int index;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_list_san_pham);
        txtPrdName = (EditText) findViewById(R.id.edt_prd_name);
        txtPrdPrice = (EditText) findViewById(R.id.edt_prd_price);
        btnThemPrd = (Button) findViewById(R.id.btn_them_prd);

//        SanPham sanPham = new SanPham("abc","123");
//        listSanPham.add(sanPham);

        recyclerView = (RecyclerView) findViewById(R.id.list_recycler_view_product);
        listItemSamPhamAdapter = new ListItemSamPhamAdapter(listSanPham,this,this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listItemSamPhamAdapter);


        btnThemPrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = txtPrdName.getText().toString();
                    int price = Integer.parseInt(txtPrdPrice.getText().toString());
                    if("".equals(name)|| price <0){
                        Toast.makeText(ListSanPhamActivity.this,"input data invalid",Toast.LENGTH_SHORT).show();
                    }else{
                        SanPham sanPham = new SanPham(txtPrdName.getText().toString(),txtPrdPrice.getText().toString());
                        listSanPham.add(0,sanPham);
                        listItemSamPhamAdapter.notifyDataSetChanged();
                        txtPrdName.setText("");
                        txtPrdPrice.setText("");
                        txtPrdName.requestFocus();
                    }

                }catch (Exception e){
                    Toast.makeText(ListSanPhamActivity.this,"input data invalid",Toast.LENGTH_LONG).show();
                }



            }
        });



    }

    @Override
    public void onClickItemDel(int i) {

        listSanPham.remove(i);
        listItemSamPhamAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickItemEdit(SanPham view, int i) {
        index = i;
        Intent intent = new Intent(this,EditSanPham.class);
        intent.putExtra("name", view.getProductName());
        intent.putExtra("price", view.getProductPrice());
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            SanPham sanPham = new SanPham(data.getStringExtra("name"),data.getStringExtra("price"));
            listSanPham.set(index,sanPham);
            listItemSamPhamAdapter.notifyDataSetChanged();
        }
    }
}

