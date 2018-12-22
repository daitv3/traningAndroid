package com.example.administrator.traning.salon;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.traning.R;
import com.squareup.picasso.Picasso;

public class ListItemSalon extends RecyclerView.Adapter <ListItemSalon.MyViewHolder>{
    ListSalon listSalon = new ListSalon();
    Context context;
    SetOnDetailSalonListener setOnDetailSalonListener;

    public ListItemSalon(){};

    public ListItemSalon(ListSalon listSalon, Context context, SetOnDetailSalonListener setOnDetailSalonListener) {
        this.listSalon = listSalon;
        this.context = context;
        this.setOnDetailSalonListener = setOnDetailSalonListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        LayoutInflater inflater  = (LayoutInflater) contextName.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_salon, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.salonName.setText( listSalon.getData().get(i).getName_salon());
        myViewHolder.salonAddress.setText(listSalon.getData().get(i).getAddress());


        String url = listSalon.getData().get(i).getImage_salon().get(0);


        if(url.indexOf("http") != -1){
            getImg(myViewHolder.img_salon,url);
        }else{
            getImg(myViewHolder.img_salon,"https://www.vatgia.com/pictures_fullsize/xnl1282829195.jpg");
        }
//          getImg(myViewHolder.img_salon,"https://www.vatgia.com/pictures_fullsize/xnl1282829195.jpg");

        final  int pos = i;
        myViewHolder.btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnDetailSalonListener.onClickDetail(listSalon.getData().get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listSalon != null) {
            return listSalon.getData().size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img_salon;
        TextView salonName;
        TextView salonAddress;
        Button btnBookNow;



        public MyViewHolder( View itemView) {
            super(itemView);
            salonName = (TextView) itemView.findViewById(R.id.salon_name);
            img_salon = (ImageView) itemView.findViewById(R.id.img_salon);
            salonAddress = (TextView) itemView.findViewById(R.id.salon_address);
            btnBookNow = (Button) itemView.findViewById(R.id.btn_booknow);
        }


    }
    interface SetOnDetailSalonListener{
        void onClickDetail(Object obj);
    }

    /**
     * use lib picasso set img from url img
     * */
    private void getImg(ImageView img, String url){
        Picasso.get()
                .load(Uri.parse(url))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(img);
    }

}
