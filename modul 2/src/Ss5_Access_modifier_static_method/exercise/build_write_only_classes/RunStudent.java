package Ss5_Access_modifier_static_method.exercise.build_write_only_classes;

import java.util.Scanner;

public class RunStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.display();
        Scanner scanner =new Scanner(System.in);
        System.out.println(" enter your name ");
        String name = scanner.nextLine();
        student.setName(name);
        System.out.println(" enter your class ");
        String classa = scanner.nextLine();
        student.setClasses(classa);
        student.display();
    }
}
