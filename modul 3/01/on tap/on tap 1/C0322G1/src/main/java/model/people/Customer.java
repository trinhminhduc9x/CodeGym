package model.people;

public class Customer {
    private int id;
    private int idMember;
    private String name;
    private int number;
    private String founding;
    private String address;

    public Customer() {
    }

    public Customer(int idMember, String name, int number, String founding, String address) {
        this.idMember = idMember;
        this.name = name;
        this.number = number;
        this.founding = founding;
        this.address = address;
    }

    public Customer(int id, int idMember, String name, int number, String founding, String address) {
        this.id = id;
        this.idMember = idMember;
        this.name = name;
        this.number = number;
        this.founding = founding;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFounding() {
        return founding;
    }

    public void setFounding(String founding) {
        this.founding = founding;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
