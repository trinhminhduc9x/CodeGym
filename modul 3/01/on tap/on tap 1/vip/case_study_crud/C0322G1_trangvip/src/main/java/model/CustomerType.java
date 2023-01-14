package model;

public class CustomerType {
    private int id;
    private String nameCustomerType;

    public CustomerType() {
    }

    public CustomerType(int id, String nameCustomerType) {
        this.id = id;
        this.nameCustomerType = nameCustomerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}
