package com.example.administrator.traning.salon;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.traning.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class MainDetailSalon extends AppCompatActivity {
    ImageView img_dt_salon;
    TextView tv_name;
    TextView tv_phone;
    TextView tv_address;
    TextView tv_open_hours;
    TextView tv_description;
    TextView tv_sv_name_salon;

    ListItemServiceSalon listItemServiceSalon;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_deltail_salon);
        img_dt_salon = (ImageView) findViewById(R.id.detail_img_salon);
        tv_name = (TextView) findViewById(R.id.detail_name_salon);
        tv_phone = (TextView) findViewById(R.id.detail_phone);
        tv_address = (TextView) findViewById(R.id.detail_address);
        tv_open_hours = (TextView) findViewById(R.id.detail_opening_hours);
        tv_description = (TextView) findViewById(R.id.detail_description);
        tv_sv_name_salon = (TextView) findViewById(R.id.list_service_name_salon);
        if(getIntent()!=null){
            Salon salon = new Salon();
            String gsonSalonString = getIntent().getStringExtra("detail_salon");
            salon = new Gson().fromJson(gsonSalonString,Salon.class);
            getImg(img_dt_salon,salon.getImage_salon().get(0));
            tv_name.setText(salon.getName_salon());
            tv_phone.setText(salon.getPhone());
            tv_address.setText(salon.getAddress());
            tv_open_hours.setText(salon.getOpeningHours());
            tv_description.setText(salon.getDescription());
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0;i<salon.getRelationships().getServices().size();i++){

                stringBuffer.append(salon.getRelationships().getServices().get(i).getName());
                stringBuffer.append("___");
            }
            //tv_sv_name_salon.setText(stringBuffer.toString());
            listItemServiceSalon = new ListItemServiceSalon(salon.getRelationships(),MainDetailSalon.this);
            recyclerView = (RecyclerView) findViewById(R.id.detail_service_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainDetailSalon.this));

            recyclerView.setAdapter(listItemServiceSalon);
        }
    }

    private void getImg(ImageView img, String url){
        Picasso.get()
                .load(Uri.parse(url))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(img);
    }
}
