package Ss5_Access_modifier_static_method.practice.student;

public class RunStudent {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(111, "duc");
        Student s2 = new Student(311, "duc");
        Student s3 = new Student(211, "duc");
        Student s4 = new Student(1, "duc");
        s1.display();
        s2.display();
        s3.display();
        s4.display();
    }
}
