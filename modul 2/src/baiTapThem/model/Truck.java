package baiTapThem.model;

public class Truck extends Car {
    private double trongTai;

    public Truck() {
    }

    public Truck(double trongTai) {
        this.trongTai = trongTai;
    }

    public Truck(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    public Truck(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu) {
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
        return "Truck{" +
                super.toString() +
                "trongTai=" + trongTai +
                '}';
    }
    //public Truck(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu, double trongTai)
    public  String getToCSV(){
        return getBienKiemSoat()+","+getTemHangSanXuat()+","+getNamSanXuat()+","+getChuSoHuu()+","+ getTrongTai();
    }
}
