package com.iteso.test;

import android.content.Intent;
import android.support.v4.app.Fragment; //duda con este import, me daba error sin el support.v4.app
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.test.beans.ItemProduct;

import java.util.ArrayList;
import java.util.Iterator;

public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ItemProduct> myDataSet;
    RecyclerView recyclerView;

    public FragmentTechnology() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        recyclerView = (RecyclerView)
                view.findViewById(R.id.fragment_technology_recycler_view);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


    myDataSet = new ArrayList<ItemProduct>();
    ItemProduct itemProduct = new ItemProduct();
     itemProduct.setTitle("MacBook Pro 17\"");
     itemProduct.setStore("BestBuy");
     itemProduct.setLocation("Zapopan, Jalisco");
     itemProduct.setPhone("33 12345678");
     itemProduct.setImage(0);
     itemProduct.setDescription("Llevate esta Mac con un 30% de descuento para que puedas programar para XCode y Android sin tener que batallar tanto como en tu Windows");
            myDataSet.add(itemProduct);

        ItemProduct itemAlienware = new ItemProduct();
        itemAlienware.setTitle("Alienware 15 R4\"");
        itemAlienware.setStore("BestBuy");
        itemAlienware.setLocation("Zapopan, Jalisco");
        itemAlienware.setPhone("33 12345678");
        itemAlienware.setImage(1);
        itemAlienware.setDescription("Llevate esta Alienware con un 60% de descuento para que puedas programar para XCode y Android sin tener que batallar tanto como en tu Mac gg");
        myDataSet.add(itemAlienware);



    mAdapter = new AdapterProduct (getActivity(), myDataSet);
    recyclerView.setAdapter(mAdapter);
    return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra("ITEM");
        Iterator<ItemProduct> iterator = myDataSet.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProduct item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                myDataSet.set(position, itemProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }


}
