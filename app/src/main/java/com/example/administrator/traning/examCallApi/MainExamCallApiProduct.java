package com.example.administrator.traning.examCallApi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.traning.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainExamCallApiProduct extends AppCompatActivity implements ListItemProduct.SetOndeleteProduceListener, ListItemProduct.SetOnEditProduceListener{
    final String BASE_URL = "http://45.77.27.89:8088/api/";
    Retrofit retrofit;
    OnCallApiInterface myRetrofitAPI;
    Button btn_save ;
    EditText itemProduceName;
    EditText price;
    RecyclerView recyclerView;
    ListItemProduct listItemProduct;
    TextView textViewId;
    public static boolean TYPE_SAVE = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_call_api_product);

        getDataFromLayout();
        btn_save = (Button) findViewById(R.id.btn_save_product);
        itemProduceName = (EditText) findViewById(R.id.api_product_name);
        price = (EditText) findViewById(R.id.api_product_price);
        textViewId = (TextView) findViewById(R.id.api_product_id);
        //add produce
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()) .build();

                myRetrofitAPI = retrofit.create(OnCallApiInterface.class);
                final Product product = new Product();
                product.setProduce(itemProduceName.getText().toString());
                product.setPrice(price.getText().toString());
                product.setId(textViewId.getText().toString());
                if(TYPE_SAVE){
                    myRetrofitAPI.add_produce( product).enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                            if(response.isSuccessful()) {
                                Toast.makeText(MainExamCallApiProduct.this, "OK " + product.toString(), Toast.LENGTH_LONG).show();
                                getDataFromLayout();
                            }else{
                                Toast.makeText(MainExamCallApiProduct.this, "ERROR " + product.toString(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                            Toast.makeText(MainExamCallApiProduct.this, " Failed" + product.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }else {
//                    myRetrofitAPI.update_produce(product).enqueue(new Callback<Object>() {
                    myRetrofitAPI.update_produce(product.getId(),product.getProduce(),product.getPrice()).enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                            if(response.isSuccessful()) {
                                Toast.makeText(MainExamCallApiProduct.this, "OK update" + product.toString(), Toast.LENGTH_LONG).show();
                                getDataFromLayout();
                            }else{
                                Toast.makeText(MainExamCallApiProduct.this, "ERROR update" + product.toString(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                            Toast.makeText(MainExamCallApiProduct.this, " Failed update" + product.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        listItemProduct.notifyDataSetChanged();


    }

    @Override
    public void onClickItemDel(Object obj) {
        //call api del prd
    }

    @Override
    public void onClickItemEdit(Object obj) {
        Product product = (Product) obj;
        textViewId.setText(product.getId());
        itemProduceName.setText(product.getProduce());
        price.setText(product.getPrice());
        TYPE_SAVE = false;

    }

    private void getDataFromLayout(){
        retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        myRetrofitAPI = retrofit.create(OnCallApiInterface.class);



        myRetrofitAPI.list_produce().enqueue(new Callback<ListProduce>() {
            @Override
            public void onResponse(Call<ListProduce> call, Response<ListProduce> response) {

                listItemProduct = new ListItemProduct(response.body(),MainExamCallApiProduct.this,MainExamCallApiProduct.this,MainExamCallApiProduct.this);
                recyclerView = (RecyclerView) findViewById(R.id.list_recycler_view_product_api);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainExamCallApiProduct.this));

                recyclerView.setAdapter(listItemProduct);
            }

            @Override
            public void onFailure(Call<ListProduce> call, Throwable t) {
                Toast.makeText(MainExamCallApiProduct.this,"Faild",Toast.LENGTH_LONG).show();
            }
        });
    }
}
