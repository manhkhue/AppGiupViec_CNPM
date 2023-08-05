package com.example.appgiupviec.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class TinTuc {
    private String MaTinTuc;
    private String TieuDe;
    private String NoiDung;
    private String HinhAnh;


    public TinTuc(JSONObject object) throws JSONException {
        MaTinTuc = object.getString("id");
        TieuDe = object.getString("TieuDe");
        NoiDung = object.getString("NoiDung");
        HinhAnh = object.getString("linkAnh");
    }
    public TinTuc(String tieuDe, String hinhAnh) {
        TieuDe = tieuDe;
        HinhAnh = hinhAnh;
    }

    public String getMaTinTuc() {
        return MaTinTuc;
    }

    public void setMaTinTuc(String maTinTuc) {
        MaTinTuc = maTinTuc;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
