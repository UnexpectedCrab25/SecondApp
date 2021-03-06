package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
TextView text1;
TextView text2;
Button button1;
Button button2;
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    View.OnLongClickListener longClickListener;
    SeekBar seekBar;

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
        seekBar = findViewById(R.id.seekBar);
        editor.putString("InitialSize",""+(int)(text1.getTextSize()) );
        editor.apply();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text1.setTextSize(seekBar.getProgress());
                text2.setTextSize(seekBar.getProgress());
                button1.setTextSize(seekBar.getProgress());
                button2.setTextSize(seekBar.getProgress());
                editor.putString("Size", "" + seekBar.getProgress());
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar.make(seekBar, "Text Size: " + seekBar.getProgress(),1000).show();
            }
        });
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
        text2.setText(shared.getString("NumClicks" + text2.getId(), "0"));
        button1.setText(shared.getString("NumClicks" + button1.getId(), "0"));
        button2.setText(shared.getString("NumClicks" + button2.getId(), "0"));
        seekBar.setProgress(Integer.parseInt(shared.getString("Size","30")));
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
        editor.clear();
        text1.setText("0");
        text2.setText("0");
        button1.setText("0");
        button2.setText("0");
        editor.putString("NumClicks" + text1.getId(),"0");
        editor.putString("NumClicks" + text2.getId(),"0");
        editor.putString("NumClicks" + button1.getId(),"0");
        editor.putString("NumClicks" + button2.getId(),"0");
        System.out.println("test: 4 "+text1.getTextSize());
        seekBar.setProgress(30);
//        seekBar.setProgress((int)Float.parseFloat(shared.getString("InitialSize","" + text1.getTextSize())));
        editor.apply();

    }


}