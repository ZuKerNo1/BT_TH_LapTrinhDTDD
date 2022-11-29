package com.example.baiktra3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.baiktra3.adapter.MyAdapter;
import com.example.baiktra3.model.englist;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    EditText editTextVD;
    Button btn, back;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<englist> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int type = bundle.getInt("type");

        editTextVD = findViewById(R.id.etA);
        btn = findViewById(R.id.button);
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.listResult);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        list.add(new englist("Hiện tại đơn", "I alway love you"));
        list.add(new englist("Hiện tại tiếp diễn", "I am loving you"));
        list.add(new englist("Quá khứ đơn", "i was ate dinner"));




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (type){
                    case 1:
                        addList("Hiện tại đơn");
                        break;
                    case 2:
                        addList("Hiện tại tiếp diễn");
                        break;
                    case 3:
                        addList("Quá khứ đơn");
                        break;
                    case 4:
                        addList("Quá khứ tiếp diễn");
                        break;
                    case 5:
                        addList("Tương lai đơn");
                        break;
                    case 6:
                        addList("Tương lai gần");
                        break;
                }
            }
        });

    }

    public void addList(String type){

        String nhapvidu = editTextVD.getText().toString();
        list.add(new englist(type, nhapvidu));
//
        myAdapter.notifyDataSetChanged();

    }


}