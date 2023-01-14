package model.people;

public class TheLoai {
    int SttTheLoai;
    String TenTheLoai;

    public TheLoai() {
    }

    public TheLoai(int sttTheLoai, String tenTheLoai) {
        SttTheLoai = sttTheLoai;
        TenTheLoai = tenTheLoai;
    }

    public int getSttTheLoai() {
        return SttTheLoai;
    }

    public void setSttTheLoai(int sttTheLoai) {
        SttTheLoai = sttTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }
}
