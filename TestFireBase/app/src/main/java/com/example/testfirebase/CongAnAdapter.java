package com.example.testfirebase;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.makeramen.roundedimageview.RoundedImageView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CongAnAdapter extends ArrayAdapter<CongAn> {
    private Activity activity;
    private int resource;
    private List<CongAn> objects;
    public CongAnAdapter(@NonNull Activity activity, int resource, @NonNull List<CongAn> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource , null);
        TextView ten = view.findViewById(R.id.tenCongAn);
        TextView capBac = view.findViewById(R.id.capBac);
        TextView quocGia = view.findViewById(R.id.quocGia);
        TextView noiCongTac = view.findViewById(R.id.noiCongTac);
        TextView soSao = view.findViewById(R.id.sao);
        RoundedImageView hinhAnh = view.findViewById(R.id.hinhAnh);

        CongAn congAn = this.objects.get(position);
        ten.setText(String.format("%s", congAn.ten));
        capBac.setText(String.format("%s", congAn.capBac));
        noiCongTac.setText(String.format("%s", congAn.noiCongTac));
        quocGia.setText(String.format("%s", congAn.quocGia));
        soSao.setText(String.format("%s Sao", congAn.sao));
        hinhAnh.setImageResource(Integer.parseInt(String.format("%d", congAn.hinhAnh)));


        ImageView btnMenu = view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(activity,view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.item_them_sv) {

                            Toast.makeText (activity,"Bạn đã nhấn nút Thêm", Toast
                                    .LENGTH_LONG) .show();
                        }
                        else if (menuItem.getItemId() == R.id.item_sua_sv) {

                            Toast.makeText (activity,"Bạn đã nhấn nút Sửa", Toast
                                    .LENGTH_LONG) .show();
                        }
                        else if (menuItem.getItemId() == R.id.item_xoa_sv) {

                            Toast.makeText (activity,"Bạn đã nhấn nút Xóa", Toast
                                    .LENGTH_LONG) .show();
                        }
                        return false;
                    }
                });
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.show();
            }
        });
        return view;
    }

}
