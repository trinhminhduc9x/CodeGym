package Ss4_Lop_va_doi_tuong_trong_Java.thuchanh;

public class Student {
    private int id;// thuộc tính, biến toàn cục, instance ( biến thuộc về đối tượng )
    String name;
    String address;
    boolean gender;
    String email;

    //construtor khong tham so
    public Student() {
    }

    public Student(int id, String name, String address, boolean gender, String email) {
        //  có thể gọi constructor khác thông qua từ khóa this
        this(id, name);
//        this.name=name;
//        this.id=id;
        this.address = address;
        this.gender = gender;
        this.email = email;
    }
    public Student(int id, String name){
        this.id =id;
        this.name=name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String display(){
        return " Rectangle {" + "name la =" + this.name + " , address=" + this.address + "}";
    }
}