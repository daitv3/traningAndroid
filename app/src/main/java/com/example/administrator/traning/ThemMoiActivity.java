package com.example.administrator.traning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemMoiActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nv);
        final EditText txtName = (EditText)findViewById(R.id.txt_name);
        final EditText txtAddress = (EditText)findViewById(R.id.txt_address);

        Button btnOk = (Button) findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = new NhanVien();
                nv.setName(txtName.getText().toString());
                nv.setAddress(txtAddress.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("name",nv.getName());
                intent.putExtra("address",nv.getAddress());
                setResult(1,intent);
                finish();
            }
        });
    }
}
