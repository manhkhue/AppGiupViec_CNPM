package com.example.appgiupviec.Model;

public class ThoiLuong {
    private String thoiLuong;
    private String TongGia;
    public String getTongGia() {
        return TongGia;
    }

    public void setTongGia(String tongGia) {
        TongGia = tongGia;
    }


    public ThoiLuong(String thoiLuong, String tongGia) {
        this.thoiLuong = thoiLuong;
        TongGia = tongGia;
    }

    public ThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }
}
