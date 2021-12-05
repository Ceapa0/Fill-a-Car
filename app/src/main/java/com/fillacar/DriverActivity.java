package com.fillacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.function.ToIntFunction;


public class DriverActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ExampleItem> exampleList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_driver);

        String value=getIntent().getStringExtra("inst");
        int s= Integer.parseInt(value);
        if(s==0) {
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Costin Stan", "17:00 500m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ciprian Simion", "17:03 100m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Robert Cristi", "17:05 200m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Theodor Florian", "17:08 50m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gabi Iulian", "17:10 400m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Iuliu Raluca", "17:11 40m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Denis Ramona", "17:12 350m"));
        }
        else
        {
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Neculai David", "17:00 10m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Olga Cristian", "17:01 20m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Lidia Timotei", "17:02 40m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Petronela Valerian", "17:03 100m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Virgil Eliza", "17:03 15m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Ghiță Theodor", "17:05 20m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Vasilica Eliza", "17:06 30m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Rareș Livia", "17:06 35m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Dorian Angela", "17:06 60m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Adam Marius", "17:07 100m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Theodor Clara", "17:07 80m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Olimpia Ilie", "17:09 25m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Manuel Flaviu", "17:10 75m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Anamaria Ștefania", "17:11 50m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Ruxandra Filip", "17:15 23m"));
        }
        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //exampleList.get(position);
                mAdapter.notifyItemChanged(position);
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });

        EditText editText=findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    ArrayList<ExampleItem>filteredList;
    private void filter(String text){
        filteredList= new ArrayList<>();
        for(ExampleItem item: exampleList){
            if(item.getmText2().toLowerCase().contains(text.toLowerCase()) || item.getmText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }
    public void chooseLocation(View view)
    {
        Intent intent=new Intent(view.getContext(),MapsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }

}

