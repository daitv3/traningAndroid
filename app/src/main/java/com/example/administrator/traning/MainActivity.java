package com.example.administrator.traning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static  ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
    ListView listViewDanhSach ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         listViewDanhSach = (ListView) findViewById(R.id.lv_list_danh_sach);




        NhanVien headerNV = new NhanVien();
        headerNV.setStt("STT");
        headerNV.setName("NAME");
        headerNV.setAddress("Address");
        listNhanVien.add(headerNV);


//        Intent intent = new Intent();
//        if (getIntent()!= null){
//            NhanVien nv1 = new NhanVien();
//            Integer stt = listNhanVien.size()+1;
//            nv1.setStt(stt.toString());
//            nv1.setName(getIntent().getStringExtra("name"));
//            nv1.setAddress(getIntent().getStringExtra("address"));
//            listNhanVien.add(nv1);
//        }


        ArrayAdapter<NhanVien> arrayAdapter = new ArrayAdapter<NhanVien>(this,android.R.layout.simple_list_item_1,listNhanVien);
        listViewDanhSach.setAdapter(arrayAdapter);

        Button btnThem = (Button)findViewById(R.id.btn_them);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThemMoiActivity.class);
                startActivityForResult(intent,1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            NhanVien nv1 = new NhanVien();
            Integer stt = listNhanVien.size()+1;
            nv1.setStt(stt.toString());
            nv1.setName(data.getStringExtra("name"));
            nv1.setAddress(data.getStringExtra("address"));
            listNhanVien.add(nv1);
            ArrayAdapter<NhanVien> arrayAdapter = new ArrayAdapter<NhanVien>(this,android.R.layout.simple_list_item_1,listNhanVien);
            listViewDanhSach.setAdapter(arrayAdapter);
        }
    }
}

class NhanVien{
    private String stt;
    private String Name;
    private String address;

    public String getStt() {
        return stt;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return address;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.getStt()+" "+ this.getName()+" "+this.getAddress();
    }
}