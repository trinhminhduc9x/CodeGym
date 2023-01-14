package baiTapThem.model;

public abstract class Car {
    private String bienKiemSoat;
    private String temHangSanXuat;
    private String namSanXuat;
    private String chuSoHuu;

    public Car() {
    }

    public Car(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.temHangSanXuat = temHangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTemHangSanXuat() {
        return temHangSanXuat;
    }

    public void setTemHangSanXuat(String temHangSanXuat) {
        this.temHangSanXuat = temHangSanXuat;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", temHangSanXuat='" + temHangSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\''
                ;
    }
}
