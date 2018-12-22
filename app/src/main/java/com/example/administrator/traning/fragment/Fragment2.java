package com.example.administrator.traning.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class Fragment2 extends Fragment {

    OnClickTextViewListener1 onClickTextViewListener1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_demo2,container,false);
        TextView textView = (TextView) view.findViewById(R.id.name4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTextViewListener1.onClickItemListener1();
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onClickTextViewListener1 = (OnClickTextViewListener1) context;
    }

    interface OnClickTextViewListener1{
         void onClickItemListener1();
    }
}
