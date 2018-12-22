package com.example.administrator.traning.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.traning.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainDemoActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final  SharedPreferences sharedPreferences = getSharedPreferences("testInFo", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_demo_preference);

        Button btnLuu = (Button) findViewById(R.id.btn_luuTT);
        Button btnXoa = (Button) findViewById(R.id.btn_xoaTT);

        String message = sharedPreferences.getString("OK123aaa","no co thong tin");
        Toast.makeText(MainDemoActivity.this,message,Toast.LENGTH_SHORT).show();

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              editor.putString("OK123aaa","luu ok");
              editor.commit();

              Toast.makeText(MainDemoActivity.this,"Luu ok roi do, vao thu muc ma xem",Toast.LENGTH_SHORT).show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("OK123aaa");
                editor.commit();
                Toast.makeText(MainDemoActivity.this,"xoa ok roi do, vao xem la bi mat roi",Toast.LENGTH_SHORT).show();
            }
        });

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("fileOut111.txt",MODE_APPEND);
            String data = "abc12313";
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
            String s = Environment.getDownloadCacheDirectory().getAbsolutePath();
            String sa = Environment.getExternalStorageDirectory().getPath();
            Log.d("s123", "onCreate: sss"+s);
            Log.d("s1233", "onCreate: sss"+sa);
            File file = new File(s +"/sss.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
