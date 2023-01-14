package ss5_static_access_modifer;

public class Student{
    private int id;
    private String name;
    private String address;
    private boolean gender;
    private String email;
    public static String school="CodeGym";

    public Student() {
    }
    public Student(int id, String name, String address, boolean gender, String email, String school) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.school = school;
    }
    public Student(int id, String name, String address, boolean gender, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id>0){
            this.id = id;
        }
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
// hàm tostring biểu diễn thông tin của đối tượng
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

}
