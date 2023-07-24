package com.example.appgiupviec.Model;

public class User {
    private String tenUser;
    private String SoDienThoai;
    private String DiaChi;
    private boolean GioiTinh;
    public User(String tenUser, String soDienThoai, String diaChi, boolean gioiTinh) {
        this.tenUser = tenUser;
        SoDienThoai = soDienThoai;
        DiaChi = diaChi;
        GioiTinh = gioiTinh;
    }
    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }



}
