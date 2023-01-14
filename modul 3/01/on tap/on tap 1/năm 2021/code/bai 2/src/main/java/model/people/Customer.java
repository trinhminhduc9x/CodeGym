package model.people;

public class Customer {
        private int id;
        private int customerTypeId;
        private String name;
        private String phoneNumber;
        private String address;
    public Customer() {
    }

    public Customer(int id, int customerTypeId, String name, String phoneNumber, String address) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(int customerTypeId, String name, String phoneNumber, String address) {
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
