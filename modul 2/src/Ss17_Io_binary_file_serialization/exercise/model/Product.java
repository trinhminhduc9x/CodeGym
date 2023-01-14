package Ss17_Io_binary_file_serialization.exercise.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String hangSanSuat;
    private int gia;
    private String cacMoTaKhac;

    public Product(int id, String name, String hangSanSuat, int gia, String cacMoTaKhac) {
        this.id = id;
        this.name = name;
        this.hangSanSuat = hangSanSuat;
        this.gia = gia;
        this.cacMoTaKhac = cacMoTaKhac;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHangSanSuat() {
        return hangSanSuat;
    }

    public void setHangSanSuat(String hangSanSuat) {
        this.hangSanSuat = hangSanSuat;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getCacMoTaKhac() {
        return cacMoTaKhac;
    }

    public void setCacMoTaKhac(String cacMoTaKhac) {
        this.cacMoTaKhac = cacMoTaKhac;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hangSanSuat='" + hangSanSuat + '\'' +
                ", gia=" + gia +
                ", cacMoTaKhac='" + cacMoTaKhac + '\'' +
                '}';
    }
}
