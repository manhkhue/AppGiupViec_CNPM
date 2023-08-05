package com.example.appgiupviec.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class ThongBao {
    private String MaThongBao;
    private String TieuDe;
    private String HinhAnh;
    private String NoiDung;


    public ThongBao (JSONObject object) throws JSONException{
        MaThongBao = object.getString("id");
        TieuDe = object.getString("TieuDe");
        NoiDung = object.getString("NoiDung");
        HinhAnh = object.getString("linkAnh");
    }
    public ThongBao(String tieuDe, String hinhAnh, String noiDung) {
        TieuDe = tieuDe;
        HinhAnh = hinhAnh;
        NoiDung = noiDung;
    }

    public String getMaThongBao() {
        return MaThongBao;
    }

    public void setMaThongBao(String maThongBao) {
        MaThongBao = maThongBao;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
