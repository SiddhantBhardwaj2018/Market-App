package com.siddhantbhardwaj.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {


    RecyclerView recyclerView;

    List<Item> itemList;

    CustomAdaptor customAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        Item itemOne = new Item(R.drawable.fruit,"Fruits","Fresh Fruits From the Garden");
        Item itemTwo = new Item(R.drawable.vegitables,"Vegetables","Delicious Vegetables");
        Item itemThree = new Item(R.drawable.bread,"Bakery","Bread and Beans");
        Item itemnFour = new Item(R.drawable.beverage,"Beverage","Juice, Tea, Coffee and Soda");
        Item itemFive = new Item(R.drawable.milk,"Milk","Milk, Shakes and Yogurt");
        Item itemSix = new Item(R.drawable.popcorn,"Snacks","Popcorn, Snacks and Fries");

        itemList.add(itemOne);
        itemList.add(itemTwo);
        itemList.add(itemThree);
        itemList.add(itemnFour);
        itemList.add(itemFive);
        itemList.add(itemSix);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        customAdaptor = new CustomAdaptor(itemList);
        recyclerView.setAdapter(customAdaptor);

        customAdaptor.setItemClickListener(this);


    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(
                MainActivity.this,
                "You choose: " + itemList.get(pos).itemName,
                Toast.LENGTH_SHORT
        ).show();
    }
}