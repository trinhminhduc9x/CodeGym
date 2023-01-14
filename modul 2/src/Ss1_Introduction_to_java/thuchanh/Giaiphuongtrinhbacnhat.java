package Ss1_Introduction_to_java.baitap;


import java.util.Scanner;

public class Giaiphuongtrinhbacnhat {
    public static void main(String[] args) {
        System.out.print("Linear Equation Resolver");
        System.out.print("Given a equation as 'a*x + b = c', please enter constants : ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.println("c: ");
        double c = scanner.nextDouble();
        if (a != 0 ){
            double answer = (c - b) / a;
            System.out.printf(" Equation pass with x = %f!\n ", answer);

        }else {
            if (b==c){
                System.out.print(" The solution is all x! ");

            }else {
                System.out.println(" no solution");
            }

        }
    }
}
