package com.example.administrator.traning.kiemtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.traning.R;

public class EditSanPham extends Activity{

    EditText txtName;
    EditText txtPrice;
    Button btnEdit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_edit_san_pham);
        if(getIntent() != null){
            txtName = (EditText) findViewById(R.id.edt_prd_name_edit);
            txtPrice = (EditText) findViewById(R.id.edt_prd_price_edit);
            txtName.setText(getIntent().getStringExtra("name"));
            txtPrice.setText(getIntent().getStringExtra("price"));

        }
        btnEdit = (Button)findViewById(R.id.btn_them_prd);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = txtName.getText().toString();
                    int price = Integer.parseInt(txtPrice.getText().toString());
                    if ("".equals(name) || price < 0) {
                        Toast.makeText(EditSanPham.this, "input data invalid", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("name", txtName.getText().toString());
                        intent.putExtra("price", txtPrice.getText().toString());
                        setResult(1, intent);
                        finish();
                    }
                }catch (Exception e){
                    Toast.makeText(EditSanPham.this, "input data invalid", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
