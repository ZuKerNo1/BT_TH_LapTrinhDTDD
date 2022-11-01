package com.example.sqlite;

public class Category {
    private int maDM;
    private String loai;

    public Category() {
    }

    public Category(int maDM, String loai) {
        this.maDM = maDM;
        this.loai = loai;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
