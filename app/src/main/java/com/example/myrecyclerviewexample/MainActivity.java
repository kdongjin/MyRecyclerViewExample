package com.example.myrecyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );

        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> dataList = new ArrayList<>();

        for(int i=0; i<10; i++){
            dataList.add(new CardItem(i+"번째", "설명"+i));
        }

        MyRecyclerAdapter myRecyclerAdapter=new MyRecyclerAdapter(this, dataList);
        recyclerView.setAdapter(myRecyclerAdapter);
    }
}