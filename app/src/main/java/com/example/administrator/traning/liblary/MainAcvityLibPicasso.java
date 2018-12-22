package com.example.administrator.traning.liblary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.administrator.traning.R;
import com.squareup.picasso.Picasso;

public class MainAcvityLibPicasso extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_lib);
        ImageView imageView = (ImageView) findViewById(R.id.img_picasso);
       // Picasso.get().load("https://www.vatgia.com/pictures_fullsize/xnl1282829195.jpg").into(imageView);
        Picasso.get()
                .load("https://www.vatgia.com/pictures_fullsize/xnl1282829195.jpg")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);
    }
}
