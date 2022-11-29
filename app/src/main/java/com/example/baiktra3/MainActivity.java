package com.example.baiktra3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView cardHTD, cardHTTD, cardQKD, cardQKTD, cardTLD, cardTLG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardHTD = findViewById(R.id.cardHTD);
        cardHTTD = findViewById(R.id.cardHTTD);
        cardQKD = findViewById(R.id.cardQKD);
        cardQKTD = findViewById(R.id.cardQKTD);
        cardTLD = findViewById(R.id.cardTLD);
        cardTLG = findViewById(R.id.cardTLG);


        cardHTD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(1);
            }
        });

        cardHTTD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(2);
            }
        });

        cardQKD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(3);
            }
        });

        cardQKTD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(4);
            }
        });

        cardTLD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(5);
            }
        });

        cardTLG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent(6);
            }
        });



    }

    public void Intent(int type){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}