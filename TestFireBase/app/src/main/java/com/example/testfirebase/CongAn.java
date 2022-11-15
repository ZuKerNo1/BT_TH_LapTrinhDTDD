package com.example.testfirebase;

public class CongAn {
    String id, ten, capBac, quocGia, noiCongTac;
    int hinhAnh, sao;

    @Override
    public String toString() {
        return "CongAn{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", capBac='" + capBac + '\'' +
                ", quocGia='" + quocGia + '\'' +
                ", noiCongTac='" + noiCongTac + '\'' +
                ", hinhAnh=" + hinhAnh +
                ", sao=" + sao +
                '}';
    }

    public CongAn() {
    }

    public CongAn(String id, String ten, String capBac, String quocGia, String noiCongTac, int hinhAnh, int sao) {
        this.id = id;
        this.ten = ten;
        this.capBac = capBac;
        this.quocGia = quocGia;
        this.noiCongTac = noiCongTac;
        this.hinhAnh = hinhAnh;
        this.sao = sao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getNoiCongTac() {
        return noiCongTac;
    }

    public void setNoiCongTac(String noiCongTac) {
        this.noiCongTac = noiCongTac;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }
}
