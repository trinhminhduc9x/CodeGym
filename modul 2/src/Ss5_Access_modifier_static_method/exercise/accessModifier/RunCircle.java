package Ss5_Access_modifier_static_method.exercise.accessModifier;

import java.util.Scanner;

public class RunCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        circle.display();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" enter your radius");
        double radius = Double.parseDouble(scanner.nextLine());
        circle.setRadius(radius);
        System.out.println(" enter your color");
        String color = scanner.nextLine();
        circle.setColor(color);
        circle.display();
    }
}
