package com.iteso.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.test.beans.ItemProduct;

public class ActivityDetail extends AppCompatActivity {

    EditText title, store, location, phone;
    ImageView image;
    ItemProduct itemProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        itemProduct = getIntent().getParcelableExtra("ITEM");
        title = (EditText) findViewById(R.id.activity_detail_title);
        store = (EditText) findViewById(R.id.activity_detail_store);
        location = (EditText) findViewById(R.id.activity_detail_location);
        image = (ImageView) findViewById(R.id.activity_detail_image);
        phone = (EditText) findViewById(R.id.activity_detail_phone);
        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());

        switch(itemProduct.getImage()){
            case 0:
                image.setImageResource(R.drawable.mac); break;
            case 1:
                image.setImageResource(R.drawable.alienware); break;
            case 2:
                image.setImageResource(R.drawable.mac); break;
        }
    }

    public void onClick(View v){
        if(v.getId() == R.id.activity_detail_save){
            itemProduct.setTitle(title.getText().toString());
            itemProduct.setStore(store.getText().toString());
            itemProduct.setLocation(location.getText().toString());
            itemProduct.setPhone(phone.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("ITEM", itemProduct);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }

    public void onCancelClick(View v){
        Intent intent = new Intent(ActivityDetail.this, ActivityMain.class);
        startActivity(intent);
    }
}
