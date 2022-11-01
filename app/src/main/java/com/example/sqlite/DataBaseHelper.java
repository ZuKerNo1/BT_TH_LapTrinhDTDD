package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "QuanLyMayTinh";
    public static final int DB_Version = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create table category
        String sql =    "CREATE TABLE Category " +
                "(maDM int primary key, " +
                "tenDM nvarchar(50) not null)";
        sqLiteDatabase.execSQL(sql);

        //Add category
        sql =   "INSERT INTO Category " +
                "VALUES(1, 'ASUS'), " +
                "(2, 'Mac')," +
                "(3, 'DELL')";
        sqLiteDatabase.execSQL(sql);

        //Create table computer
        sql =   "CREATE TABLE Computer " +
                "(maMT int primary key, " +
                "tenMT nvarchar(50) not null, " +
                "maDM int not null, " +
                "FOREIGN KEY (maDM) REFERENCES Category (maDM))";
        sqLiteDatabase.execSQL(sql);

        //Add computer
        sql =   "INSERT INTO Computer " +
                "VALUES(1, 'ROG Zephyrus', 1), " +
                "(2, 'ROG Flow', 1), " +
                "(3, 'Macbook Air M2', 2)," +
                "(4, 'Macbook Pro', 2), "+
                "(5, 'Dell Inspỉon', 3) ";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Computer";
        sqLiteDatabase.execSQL(sql);

        sql = "DROP TABLE IF EXISTS Category";
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }
}
