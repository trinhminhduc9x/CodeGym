package model.people;

public class Phim {
    private int SttPhim;
    private String TenPhim;
    private String NgayChieuPhim;
    private int SttTheLoai;
    private int SttQuocGia;
    private int SttDoTuoi;

    public Phim() {
    }

    public Phim(int sttPhim, String tenPhim, String ngayChieuPhim, int sttTheLoai, int sttQuocGia, int sttDoTuoi) {
        SttPhim = sttPhim;
        TenPhim = tenPhim;
        NgayChieuPhim = ngayChieuPhim;
        SttTheLoai = sttTheLoai;
        SttQuocGia = sttQuocGia;
        SttDoTuoi = sttDoTuoi;
    }

    public Phim(String tenPhim, String ngayChieuPhim, int sttTheLoai, int sttQuocGia, int sttDoTuoi) {
        TenPhim = tenPhim;
        NgayChieuPhim = ngayChieuPhim;
        SttTheLoai = sttTheLoai;
        SttQuocGia = sttQuocGia;
        SttDoTuoi = sttDoTuoi;
    }

    public int getSttPhim() {
        return SttPhim;
    }

    public void setSttPhim(int sttPhim) {
        SttPhim = sttPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public String getNgayChieuPhim() {
        return NgayChieuPhim;
    }

    public void setNgayChieuPhim(String ngayChieuPhim) {
        NgayChieuPhim = ngayChieuPhim;
    }

    public int getSttTheLoai() {
        return SttTheLoai;
    }

    public void setSttTheLoai(int sttTheLoai) {
        SttTheLoai = sttTheLoai;
    }

    public int getSttQuocGia() {
        return SttQuocGia;
    }

    public void setSttQuocGia(int sttQuocGia) {
        SttQuocGia = sttQuocGia;
    }

    public int getSttDoTuoi() {
        return SttDoTuoi;
    }

    public void setSttDoTuoi(int sttDoTuoi) {
        SttDoTuoi = sttDoTuoi;
    }
}
