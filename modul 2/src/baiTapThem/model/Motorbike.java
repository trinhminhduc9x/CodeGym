package baiTapThem.model;

public class Motorbike extends Car {
    private int congSuat;

    public Motorbike() {
    }

    public Motorbike(int congSuat) {
        this.congSuat = congSuat;
    }

    public Motorbike(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public Motorbike(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu) {
        super(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu);
    }

    @Override
    public String getBienKiemSoat() {
        return super.getBienKiemSoat();
    }

    @Override
    public void setBienKiemSoat(String bienKiemSoat) {
        super.setBienKiemSoat(bienKiemSoat);
    }

    @Override
    public String getTemHangSanXuat() {
        return super.getTemHangSanXuat();
    }

    @Override
    public void setTemHangSanXuat(String temHangSanXuat) {
        super.setTemHangSanXuat(temHangSanXuat);
    }

    @Override
    public String getNamSanXuat() {
        return super.getNamSanXuat();
    }

    @Override
    public void setNamSanXuat(String namSanXuat) {
        super.setNamSanXuat(namSanXuat);
    }

    @Override
    public String getChuSoHuu() {
        return super.getChuSoHuu();
    }

    @Override
    public void setChuSoHuu(String chuSoHuu) {
        super.setChuSoHuu(chuSoHuu);
    }

    @Override
    public String toString() {
        return "motorbike{" +
                super.toString() +
                "congSuat=" + congSuat +
                '}';
    }
}
