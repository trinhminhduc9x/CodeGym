package demo.model;

public class Student {
    private int MSSV ;
    private String HoTen;
    private String NgaySinh;
    private boolean GioiTinh;
    private String TenLop;
    private String Khoa;

    public Student() {
    }

    public Student(int MSSV, String hoTen, String ngaySinh, boolean gioiTinh, String tenLop, String khoa) {
        this.MSSV = MSSV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        TenLop = tenLop;
        Khoa = khoa;
    }

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "MSSV=" + MSSV +
                ", HoTen='" + HoTen + '\'' +
                ", NgaySinh='" + NgaySinh + '\'' +
                ", GioiTinh=" + GioiTinh +
                ", TenLop='" + TenLop + '\'' +
                ", Khoa='" + Khoa + '\'' +
                '}';
    }
}
