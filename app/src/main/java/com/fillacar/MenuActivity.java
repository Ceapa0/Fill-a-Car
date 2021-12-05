package com.fillacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_menu);
    }

    public void sendPassenger(View view)
    {
        String inst="0";
        Intent intent=new Intent(view.getContext(),DriverActivity.class);
        intent.putExtra("inst", "0");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
    public void sendPassenger2(View view)
    {
        String inst="1";
        Intent intent=new Intent(view.getContext(),DriverActivity.class);
        intent.putExtra("inst", "1");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
}