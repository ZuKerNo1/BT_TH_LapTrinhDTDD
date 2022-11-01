package com.example.sqlite;

public class Computer {
    private int maMT;
    private Category category;
    private String tenMT;

    public Computer() {

    }

    public Computer(int maMT, Category category, String tenMT) {
        this.maMT = maMT;
        this.category = category;
        this.tenMT = tenMT;
    }

    public int getMaMT() {
        return maMT;
    }

    public void setMaMT(int maMT) {
        this.maMT = maMT;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTenMT() {
        return tenMT;
    }

    public void setTenMT(String tenMT) {
        this.tenMT = tenMT;
    }
}
