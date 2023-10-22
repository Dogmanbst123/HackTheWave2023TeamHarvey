package com.example.hackthewave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    SearchView sv;
    String searchValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*sv.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchValue = sv.getQuery().toString();
                openPage();
            }
        });*/
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                openPage();
            }
        }, 2000);
    }

    private void openPage() {
        Intent I = new Intent(this, diagnosis.class);
        startActivity(I);
    }
}