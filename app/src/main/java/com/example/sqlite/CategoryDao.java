package com.example.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private SQLiteDatabase database;

    public CategoryDao(Context context) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Category> get(String sql, String ...doiSo) {
        List<Category> categoryList = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, doiSo);

        while (cursor.moveToNext()) {
            Category category = new Category();
            category.setMaDM(cursor.getInt(cursor.getColumnIndex("maDM")));
            category.setLoai(cursor.getString(cursor.getColumnIndex("tenDM")));

            categoryList.add(category);
        }

        return categoryList;
    }

    public List<Category> getAll() {
        String sql =    "SELECT * " +
                "FROM Category";

        return get(sql);
    }
}
