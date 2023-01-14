package model;

import java.time.LocalDate;

public class Customer {
    private  int id;
    private String name;
    private LocalDate brithday;
    private String address;
    public Customer() {
    }

    public Customer(int id, String name, LocalDate brithday, String address) {
        this.id = id;
        this.name = name;
        this.brithday = brithday;
        this.address = address;
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

    public LocalDate getBrithday() {
        return brithday;
    }

    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
