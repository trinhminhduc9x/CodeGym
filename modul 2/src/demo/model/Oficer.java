package demo.model;

public class Oficer {
    private int ID;
    private String hoVaTen;
    private boolean gioiTinh;
    private String queQuan;
    private String namSinh;
    private String chuyenMon;
    private String trinhDo;
    private double heSoLuong;
    private double phuCap;

    public Oficer() {
    }

    public Oficer(int ID, String hoVaTen, boolean gioiTinh, String queQuan, String namSinh, String chuyenMon, String trinhDo, double heSoLuong, double phuCap) {
        this.ID = ID;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
        this.chuyenMon = chuyenMon;
        this.trinhDo = trinhDo;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
    public double getThuclinh() {
        return (getPhuCap() + getHeSoLuong())*450000;
    }

    @Override
    public String toString() {
        return "Oficer{" +
                "ID=" + ID +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", queQuan='" + queQuan + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", chuyenMon='" + chuyenMon + '\'' +
                ", trinhDo='" + trinhDo + '\'' +
                ", heSoLuong=" + heSoLuong +
                ", phuCap=" + phuCap +
                ", thucLinh=" + getThuclinh() +
                '}';
    }

}
