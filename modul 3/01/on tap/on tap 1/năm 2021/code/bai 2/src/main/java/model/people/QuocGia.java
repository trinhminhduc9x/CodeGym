package model.people;

public class QuocGia {
    int SttQuocGia;
    String TenQuocGia;

    public QuocGia() {
    }

    public QuocGia(int sttQuocGia, String tenQuocGia) {
        SttQuocGia = sttQuocGia;
        TenQuocGia = tenQuocGia;
    }

    public int getSttQuocGia() {
        return SttQuocGia;
    }

    public void setSttQuocGia(int sttQuocGia) {
        SttQuocGia = sttQuocGia;
    }

    public String getTenQuocGia() {
        return TenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        TenQuocGia = tenQuocGia;
    }
}
