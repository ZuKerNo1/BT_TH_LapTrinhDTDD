package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvComputer;
    private ComputerDao computerDao;
    private ComputerAdapter computerAdapter;
    private Button btnThem;
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        getItemListView();

        getItemCategory();    }

    private void getItemCategory() {
        CategoryDao categoryDao = new CategoryDao(this);
        List<Category> categoryList = categoryDao.getAll();

        // lay ten danh muc dua vao combobox
        List<String> tenDanhMucList = new ArrayList<>();
        for (Category category: categoryList) {
            tenDanhMucList.add(category.getLoai());
        }

        categoryAdapter = new ArrayAdapter<String>(this, R.layout.item_cb, tenDanhMucList);
        autoCompleteTextView.setAdapter(categoryAdapter);

        //bat su kien khi chon
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getItemListView() {
        computerDao = new ComputerDao(this);
        List<Computer> computerList = computerDao.getAll();

        computerAdapter = new ComputerAdapter(this, R.layout.computer_item, computerList);
        lvComputer.setAdapter(computerAdapter);
    }

    private void anhXa() {
        lvComputer = findViewById(R.id.listCoputer);
        btnThem = findViewById(R.id.add);
        autoCompleteTextView = findViewById(R.id.danhMucCombobox);
    }
}