package com.example.appgiupviec.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DichVu {
    private String TenDichVu;
    private String MaDichVu;
    private String Mota;
    private String ImageUrl;
    private String DonGia;

    public DichVu(JSONObject object)throws JSONException{
        MaDichVu = object.getString("id");
        TenDichVu = object.getString("tenDichVu");
        Mota = object.getString("MoTa");
        ImageUrl = object.getString("linkAnh");
        DonGia = object.getString("DonGia");
    }
    public DichVu(String tenDichVu, String imageUrl) {
        TenDichVu = tenDichVu;
        ImageUrl = imageUrl;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        TenDichVu = tenDichVu;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        MaDichVu = maDichVu;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }
}
