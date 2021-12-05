package com.fillacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        setContentView(R.layout.activity_driver);

        String value=getIntent().getStringExtra("inst");
        int s= Integer.parseInt(value);
        if(s==0) {
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 500m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 200m"));

            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 300m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 500m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 213m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 100000m"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 Strada"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 Floresti"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 Strada"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 Floresti"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 Strada"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 Floresti"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 Strada"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Gigel Gigeleanul", "17.15 Floresti"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Bos de boss", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_driver, "Ionel Ionut", "11.21 Strada"));
        }
        else
        {
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "dddd", "17.15 500m"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "ffff", "17.25 an fatza pe avari"));
            exampleList.add(new ExampleItem(R.drawable.ic_passanger, "Issss", "11.21 200m"));
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

}

