package com.example.appgiupviec.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class NhanVien {
    private String HinhAnh;
    private String Ten;

    private String GioiTinh;
    private String SDT;

    private String MaNGV;
    private String TenDG;


    public NhanVien(JSONObject object) throws JSONException{
        MaNGV = object.getString("MaNGV");
        Ten = object.getString("TenNGV");
        SDT = object.getString("SDT");
        HinhAnh = object.getString("HinhAnh");
        TenDG = object.getString("TenDG");
    }
    public NhanVien(String hinhAnh, String ten) {
        HinhAnh = hinhAnh;
        Ten = ten;
    }

    public String getTenDG() {
        return TenDG;
    }

    public void setTenDG(String tenDG) {
        TenDG = tenDG;
    }

    public String getMaNGV() {
        return MaNGV;
    }

    public void setMaNGV(String maNGV) {
        MaNGV = maNGV;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }


    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }
}
