package com.example.listitem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> listProduct;
    Adapter productListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Trần Kim Vũ","2050531200360" , 500, R.drawable.ava, R.drawable.plus, R.drawable.minus_button));
        listProduct.add(new Product(2, "Nhà cấp 1","Xây từ bê tông cốt thép" ,10000, R.drawable.nha1, R.drawable.plus, R.drawable.minus_button));
        listProduct.add(new Product(3, "Nhà cấp 2","Xây từ bê tông cốt thép và gạch" , 8000, R.drawable.nha2, R.drawable.plus, R.drawable.minus_button));
        listProduct.add(new Product(4, "Nhà cấp 3","Đa phần là gạch" , 4000, R.drawable.nha3, R.drawable.plus, R.drawable.minus_button));
        listProduct.add(new Product(5, "Nhà cấp 4","Xây từ gạch hoặc gỗ" , 1500, R.drawable.nha4, R.drawable.plus, R.drawable.minus_button));

        productListViewAdapter = new Adapter(listProduct);
        listViewProduct = findViewById(R.id.listProduct);
        listViewProduct.setAdapter(productListViewAdapter);
        listViewProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Xác nhận !!!");
                builder.setMessage("Có muốn xóa sản phẩm này không ?");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        listProduct.remove(position);
                        listViewProduct.setAdapter(productListViewAdapter);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}