package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView text1 = findViewById(R.id.Tleft);
TextView text2 = findViewById(R.id.Tright);
Button button1 = findViewById(R.id.Bleft);
Button button2 = findViewById(R.id.Bright);
SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG ="com.mckenzieconnor.demo.prefs";
        shared = getSharedPreferences(TAG,MODE_PRIVATE);
        shared.getString("mResponse", "defaultString");
        shared.getInt("mResponseNum",99)
    }
    public void getBigger(View view){
        Textview v = (Textview) view;
//        get the value
//                cast bied as buton
//                cast value to sint
//                inceasee
//                        cast dot strong
//                set value of hgeo to bution
        String s = getText(v.getId());
        int k = Integer.parseInt(s)

    }

}