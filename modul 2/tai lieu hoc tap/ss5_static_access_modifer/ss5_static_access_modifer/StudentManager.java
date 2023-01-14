package ss5_static_access_modifer;

import java.util.Scanner;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    static Student[] students = new Student[100];
    static {
        students[0]= new Student(1,"chanh","QN",true,"chanhtv");
        students[1]= new Student(2,"chanh","QN",true,"chanhtv");
        students[2]= new Student(3,"chanh","QN",true,"chanhtv");
    }
    // CRUD
    public void display(){
        for (Student s: students) {
            if (s!=null){
                System.out.println(s);
            }else {
                break;
            }

        }
    }
    public void add(){
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("nhập giới tính");
        boolean gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("nhập giới email");
        String email = scanner.nextLine();
        Student student = new Student(id,name,address,gender,email);
        for (int i = 0; i <students.length ; i++) {
            if (students[i]==null){
                students[i]=student;
                break;
            }
        }
    }
}
