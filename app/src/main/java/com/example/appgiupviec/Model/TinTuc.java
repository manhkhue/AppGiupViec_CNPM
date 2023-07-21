package com.example.appgiupviec.Model;

public class TinTuc {
    private String TieuDe;
    private String NoiDung;
    private String HinhAnh;

    public TinTuc(String tieuDe, String hinhAnh) {
        TieuDe = tieuDe;
        HinhAnh = hinhAnh;
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
