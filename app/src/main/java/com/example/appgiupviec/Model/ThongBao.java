package com.example.appgiupviec.Model;

public class ThongBao {
    private String TieuDe;
    private String HinhAnh;
    private String NoiDung;

    public ThongBao(String tieuDe, String hinhAnh, String noiDung) {
        TieuDe = tieuDe;
        HinhAnh = "null";
        NoiDung = noiDung;
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
