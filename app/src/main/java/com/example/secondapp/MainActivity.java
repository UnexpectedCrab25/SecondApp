package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView text1;
TextView text2;
Button button1;
Button button2;
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    View.OnLongClickListener longClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG ="com.mckenzieconnor.demo.prefs";
        shared = getSharedPreferences(TAG,MODE_PRIVATE);
        editor = shared.edit();
        text1 = findViewById(R.id.Tleft);
        text2 = findViewById(R.id.Tright);
        button1 = findViewById(R.id.Bleft);
        button2 = findViewById(R.id.Bright);
        editor.putString("INITIAL" + text1.getId(),text1.getText().toString());
        editor.putString("INITIAL" + text2.getId(),text2.getText().toString());
        editor.putString("INITIAL" + button1.getId(),button1.getText().toString());
        editor.putString("INITIAL" + button2.getId(),button2.getText().toString());
        editor.apply();
        longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Reset(findViewById(R.id.main));
                return false;
            }
        };
        findViewById(R.id.main).setOnLongClickListener(longClickListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        text1.setText(shared.getString("NumClicks" + text1.getId(), "0"));
        text2.setText(shared.getString("NumClicks" + text1.getId(), "0"));
        button1.setText(shared.getString("NumClicks" + button1.getId(), "0"));
        button2.setText(shared.getString("NumClicks" + button2.getId(), "0"));
    }

    public void getBigger(View view){
        TextView v = (TextView) view;
//        get the value
//                cast bied as buton
//                cast value to sint
//                inceasee
//                        cast dot strong
//                set value of hgeo to bution
        String s = (String) shared.getString("NumClicks" + v.getId(),"0");
        int k = Integer.parseInt(s);
        k++;
        s = "" + k;
        v.setText(s);
        editor.putString("NumClicks" + v.getId(),s);
        editor.apply();
    }
    public void Reset(View view){

        text1.setText(shared.getString("INITIAL" + text1.getId(),"no"));
        text2.setText(shared.getString("INITIAL" + text2.getId(),"no"));
        button1.setText(shared.getString("INITIAL" + button1.getId(),"no"));
        button2.setText(shared.getString("INITIAL" + button2.getId(),"no"));
        editor.putString("NumClicks" + text1.getId(),text1.getText().toString());
        editor.putString("NumClicks" + text2.getId(),text2.getText().toString());
        editor.putString("NumClicks" + button1.getId(),button1.getText().toString());
        editor.putString("NumClicks" + button2.getId(),button2.getText().toString());
        editor.apply();

    }


}