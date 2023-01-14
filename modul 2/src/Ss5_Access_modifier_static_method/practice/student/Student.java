package Ss5_Access_modifier_static_method.practice.student;

public class Student {
    private int rollno;
    private String name;
    private static String college = "";

    public static void main(String[] args) {
        Student.change();
        Student s1 =new Student(111,"Duc");
        s1.display();
    }
    // constructor to initialize the variable
    Student(int r, String n) {
        rollno = r;
        name = n;
    }
    // static method to change the value of static variable
    static void change () {
        college = " CODEGYM";
    }
    //method to display values
    void display(){
        System.out.println(rollno + " "+ name + " " + college);
    }
}
