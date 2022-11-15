package com.example.testfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<CongAn> congAnArrayList;
    private ListView lvCongAn;
    private CongAnAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongAn = findViewById(R.id.lvCongAn);

        congAnArrayList = new ArrayList<>();

        congAnArrayList.add(new CongAn("1","Trần Kim Vũ", "Đại tá","VN", "Tam Kỳ", R.drawable.congan, 5));
        congAnArrayList.add(new CongAn("2","Bùi Viết Trường", "Thiếu úy","VN", "Đà Nẵng", R.drawable.congan2, 4));
        congAnArrayList.add(new CongAn("3","Lê Hoàng Anh Tuấn", "Thiếu úy","VN", "Ba Đồn", R.drawable.congan, 4));
        congAnArrayList.add(new CongAn("4","Nguyễn Văn Trung", "Thiếu úy","VN", "Quảng Ninh", R.drawable.congan2, 4));
        adapter = new CongAnAdapter(this,R.layout.activity_police_list,congAnArrayList);

        lvCongAn.setAdapter(adapter);



    }


}