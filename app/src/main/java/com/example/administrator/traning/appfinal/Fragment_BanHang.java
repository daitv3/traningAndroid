package com.example.administrator.traning.appfinal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.traning.R;

public class Fragment_BanHang extends Fragment {
    Button dau_noi;
    Button dau_noi_sim;
    Button calib_nhien_lieu;
    Button update_info;
    OnClickButtonFn onClickButtonFn;


    Context context;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        //View itemView = inflater.inflate(R.layout.fragment_fn_banhang, null);
        View itemView = inflater.inflate(R.layout.fragment_fn_banhang,container, false);
        dau_noi = (Button) itemView.findViewById(R.id.fn_dau_noi);
        dau_noi_sim = (Button) itemView.findViewById(R.id.fn_dau_noi_sim);
        calib_nhien_lieu = (Button) itemView.findViewById(R.id.fn_ho_tro);
        update_info = (Button) itemView.findViewById(R.id.fn_update_info_12);

        calib_nhien_lieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickButtonFn.onCLickButton();

//                Intent intent = new Intent(getContext(),Main_fn_Home.class);
//               startActivity(intent);




            }
        });

        return itemView;
    }

    interface OnClickButtonFn{
        void onCLickButton();
    }
}
