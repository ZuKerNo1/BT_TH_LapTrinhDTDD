package com.example.firebase_dssv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    @NonNull
    private Activity activity;
    private int resource;
    @NonNull
    private List<SinhVien> objects;


    public SinhVienAdapter(@NonNull Activity activity, int resource, @NonNull
            List<SinhVien> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater ();
        View view = inflater.inflate(this.resource, null);

        TextView txtHoTen = view.findViewById(R.id.txtHoTen);
        TextView txtEmail = view.findViewById(R.id.txtEmail);
        TextView txtMsv = view.findViewById(R.id.txtMsv);

        SinhVien sinhVien = this.objects.get(position);
        txtHoTen.setText(sinhVien.getHoTen());
        txtEmail.setText(sinhVien.getEmail());
        txtMsv.setText(sinhVien.getMsv());

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

