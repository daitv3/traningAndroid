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

public class Fragment1 extends Fragment {

    OnClickTextViewListener onClickTextViewListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_demo1,container,false);
        final TextView textView = (TextView) view.findViewById(R.id.name1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTextViewListener.onClickItemListener();
            }
        });

        TextView textView1 = (TextView) view.findViewById(R.id.name2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTextViewListener.OnClickItemByText("hhhhhhh");
            }
        });
        return view;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onClickTextViewListener = (OnClickTextViewListener) context;
    }

    interface OnClickTextViewListener{
        public void onClickItemListener();

        public void OnClickItemByText(String text);
    }
}
