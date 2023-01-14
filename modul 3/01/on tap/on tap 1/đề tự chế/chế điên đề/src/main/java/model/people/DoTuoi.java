package model.people;

public class DoTuoi {
    int SttDoTuoi;
    String TenDoTuoi;

    public DoTuoi() {
    }

    public DoTuoi(int sttDoTuoi, String tenDoTuoi) {
        SttDoTuoi = sttDoTuoi;
        TenDoTuoi = tenDoTuoi;
    }

    public int getSttDoTuoi() {
        return SttDoTuoi;
    }

    public void setSttDoTuoi(int sttDoTuoi) {
        SttDoTuoi = sttDoTuoi;
    }

    public String getTenDoTuoi() {
        return TenDoTuoi;
    }

    public void setTenDoTuoi(String tenDoTuoi) {
        TenDoTuoi = tenDoTuoi;
    }
}
