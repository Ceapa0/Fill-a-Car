package com.fillacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void sendPassenger(View view)
    {
        String inst="0";
        Intent intent=new Intent(view.getContext(),DriverActivity.class);
        intent.putExtra("inst", "0");
        view.getContext().startActivity(intent);
    }
    public void sendPassenger2(View view)
    {
        String inst="1";
        Intent intent=new Intent(view.getContext(),DriverActivity.class);
        intent.putExtra("inst", "1");
        view.getContext().startActivity(intent);
    }
}