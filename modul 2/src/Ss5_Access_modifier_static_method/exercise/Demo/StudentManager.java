package Ss5_Access_modifier_static_method.exercise.Demo;

import java.util.Scanner;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    static Student[] students = new Student[10];

    static {
        students[0] = new Student(1, "duc", "dn", true, "addd", "asd");
        students[1] = new Student(2, "duc", "dn", true, "addd", "Ad");
        students[2] = new Student(3, "duc", "dn", true, "addd", "sss");
        students[3] = new Student(4, "duc", "dn", true, "addd", "sss");
    }

    public void display() {
        for (Student i : students) {
            if (i != null) {
                System.out.println(i);
            } else {
              continue;
            }
        }
    }

    public void add() {
        System.out.println("enter id ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("enter name");
        String name = scanner.nextLine();
        System.out.println("enter address");
        String address = scanner.nextLine();
        System.out.println("enter gender");
        boolean gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("enter email");
        String email = scanner.nextLine();
        System.out.println(" enter schoole");
        String schoole = scanner.nextLine();
        Student student = new Student(id, name, address, gender, email, schoole);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public void delete() {
        System.out.println(" enter your delete number");
        int index = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.length; i++) {
            if (i == index) {
                students[i] = null;
                break;
            }
        }
    }
    public void edit(){
        System.out.println(" enter your edit number");
        int index = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.length; i++) {
            if (i == index) {
                System.out.println("enter id ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("enter name");
                String name = scanner.nextLine();
                System.out.println("enter address");
                String address = scanner.nextLine();
                System.out.println("enter gender");
                boolean gender = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("enter email");
                String email = scanner.nextLine();
                System.out.println(" enter schoole");
                String schoole = scanner.nextLine();
                Student student = new Student(id, name, address, gender, email, schoole);
                students[i] = student;
                break;
            }
        }
    }

}
