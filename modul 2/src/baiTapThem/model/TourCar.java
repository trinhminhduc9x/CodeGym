package baiTapThem.model;

public class TourCar extends Car {
    private int soChoNgoi;
    private String kieuXe;

    public TourCar() {
    }

    public TourCar(int soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public TourCar(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    public TourCar(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu) {
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
        return "tourCar{" +
                super.toString() +
                "soChoNgoi=" + soChoNgoi +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }
    public  String getToCSV(){
        return getBienKiemSoat()+","+getTemHangSanXuat()+","+getNamSanXuat()+","+getChuSoHuu()+","+ getSoChoNgoi()+","+ getKieuXe();
    }
}
