package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ComputerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Computer> computerList;

    public ComputerAdapter(Context context, int layout, List<Computer> computerList) {
        this.context = context;
        this.layout = layout;
        this.computerList = computerList;
    }

    @Override
    public int getCount() {
        return computerList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();
            //anh xa
            holder.txtTen = view.findViewById(R.id.nameCoputer);
            holder.txtDanhMuc = view.findViewById(R.id.categoryCom);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //gan gia tri
        Computer computer = computerList.get(i);
        holder.txtTen.setText(computer.getTenMT());
        holder.txtDanhMuc.setText(computer.getCategory().getLoai());

        return view;
    }

    private class ViewHolder {
        TextView txtTen, txtDanhMuc;
    }
}
