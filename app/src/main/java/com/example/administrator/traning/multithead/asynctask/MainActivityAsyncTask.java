package com.example.administrator.traning.multithead.asynctask;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class MainActivityAsyncTask extends AppCompatActivity implements MyAsyncTask.GetDataAnyscTask{
    private TextView btnDownLoad;
    private ProgressBar progressBar;
    private ImageView imageView;
    private Bitmap bitmap;
    private MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_asynctask_down_img);
        btnDownLoad = (Button) findViewById(R.id.btn_download);
        progressBar = (ProgressBar) findViewById(R.id.progress_num);
        imageView = (ImageView) findViewById(R.id.img_download);

        btnDownLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call method execute download...
                myAsyncTask = new MyAsyncTask(MainActivityAsyncTask.this);
                myAsyncTask.execute("https://znews-photo.zadn.vn/w1024/Uploaded/ofh_huqfztmf/2018_12_02/ronaldo1_1.jpg");
            }
        });
    }

    @Override
    public void getImg(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    /*public class DownLoadImg extends AsyncTask<String, Integer, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            //show % download
            *//*int n = Integer.parseInt(strings[0]);
            for (int i = 0;i<n;i++){
                publishProgress(i);
            }*//*
            //show img
            return downloadImage(strings[0]);
        }

        public DownLoadImg() {
            super();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            btnDownLoad.setEnabled(true);

            //get img downloaded to imgview
            imageView.setImageBitmap(bitmap);
            btnDownLoad.setText("OK");

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
//            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btnDownLoad.setText("Dowloading");
            btnDownLoad.setEnabled(false);
        }

        private Bitmap downloadImage(String src) {

            try {
                java.net.URL url = new java.net.URL(src);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
//                myBitmap.setWidth(400);
//                myBitmap.setHeight(400);
                return myBitmap;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }



        }


    }*/
}



