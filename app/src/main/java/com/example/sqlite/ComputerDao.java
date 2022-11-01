package com.example.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ComputerDao {
    private SQLiteDatabase database;

    public ComputerDao(Context context) {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Computer> get(String sql, String ...doiSo) {
        List<Computer> computerList = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, doiSo);

        while (cursor.moveToNext()) {
            Computer computer = new Computer();
            computer.setMaMT(cursor.getInt(cursor.getColumnIndex("Computer.maMT")));
            computer.setTenMT(cursor.getString(cursor.getColumnIndex("tenMT")));
            //set category
            Category category = new Category(cursor.getInt(cursor.getColumnIndex("maDM")), cursor.getString(cursor.getColumnIndex("tenDM")));
            computer.setCategory(category);

            computerList.add(computer);
        }

        return computerList;
    }

    public List<Computer> getAll() {
        String sql =    "SELECT * " +
                "FROM Computer, Category " +
                "WHERE Category.maDM = Computer.maDM";

        return get(sql);
    }

    public Computer getById(String id) {
        String sql =    "SELECT Computer.maMT as maMT, tenMT, maDM, tenDM " +
                "FROM Computer, Category " +
                "WHERE Category.maDM = Computer.maDM " +
                "and maDM = ?";
        List<Computer> computerList = get(sql, id);

        return computerList.get(0);
    }

    public long insert(Computer computer) {
        ContentValues values = new ContentValues();
        values.put("maMT", computer.getMaMT());
        values.put("tenMT", computer.getTenMT());
        values.put("maDM", computer.getCategory().getMaDM());

        return database.insert("Computer", null, values);
    }

    public long update(Computer computer) {
        ContentValues values = new ContentValues();
        values.put("tenMT", computer.getTenMT());
        values.put("maDM", computer.getCategory().getMaDM());

        return database.update("Computer", values, "maMT = ?", new String[]{String.valueOf(computer.getMaMT())});
    }

    public long delete(String id) {
        return database.delete("Computer", "maMT = ?", new String[]{id});
    }
}
