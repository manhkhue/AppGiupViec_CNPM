package com.example.appgiupviec.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String tenUser;
    private String SoDienThoai;
    private String DiaChi;
    private String GioiTinh;

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getMaHK() {
        return MaHK;
    }

    public void setMaHK(String maHK) {
        MaHK = maHK;
    }

    private String MaHK;
    public User(JSONObject object)throws JSONException {
        this.MaHK = object.getString("MaKH");
        this.tenUser = object.getString("TenKH");
        this.GioiTinh = object.getString("GioiTinh");
        this.DiaChi = object.getString("DiaChi");
        this.SoDienThoai = object.getString("SDT");
    }
    public User(String tenUser, String soDienThoai, String diaChi, String gioiTinh) {
        this.tenUser = tenUser;
        this.SoDienThoai = soDienThoai;
        this.DiaChi = diaChi;
        this.GioiTinh = gioiTinh;
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

    public String isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }



}
