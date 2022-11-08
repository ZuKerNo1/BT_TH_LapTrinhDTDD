package com.example.firebase_dssv;

public class SinhVien {
    private String id, Msv, HoTen,Email;

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", msv='" + Msv + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsv() {
        return Msv;
    }

    public void setMsv(String msv) {
        this.Msv = msv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public SinhVien() {
    }

    public SinhVien(String id, String Msv, String hoTen, String email) {
        this.id = id;
        this.Msv = Msv;
        HoTen = hoTen;
        Email = email;
    }
}
