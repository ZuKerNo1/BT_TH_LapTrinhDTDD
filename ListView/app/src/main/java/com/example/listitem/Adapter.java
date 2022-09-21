package com.example.listitem;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    final ArrayList<Product> listProduct;
    Adapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listProduct.get(position).productID;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.activity_item, null);
        } else viewProduct = convertView;

        Product product = (Product) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("%s", product.name));
        ((TextView) viewProduct.findViewById(R.id.infor)).setText(String.format("%s", product.infor));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Giá %d $", product.price));
        ((ImageView) viewProduct.findViewById(R.id.imgProduct)).setBackgroundResource(Integer.parseInt(String.format("%d", product.imgView)));
        ((ImageView) viewProduct.findViewById(R.id.add)).setBackgroundResource(Integer.parseInt(String.format("%d", product.add)));
        ((ImageView) viewProduct.findViewById(R.id.minus)).setBackgroundResource(Integer.parseInt(String.format("%d", product.minus)));

        return viewProduct;
    }
}
