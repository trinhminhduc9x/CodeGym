package Ss4_Lop_va_doi_tuong_trong_Java.baitap;

import Ss3_Mang_va_phuong_thuc_trong_java.baitap.QuadraticEquation;

import java.util.Scanner;

public class QuadraticEquationNew {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" enter your a number  : ");
        double a = scanner.nextDouble();
        System.out.println(" enter your b numbera : ");
        double b = scanner.nextDouble();
        System.out.println(" enter your c number: ");
        double c = scanner.nextDouble();
        quadraticEquation.setA(a);
        quadraticEquation.setB(b);
        quadraticEquation.setC(c);
        System.out.println(" result a: " + quadraticEquation.getDiscriminant());
        if (quadraticEquation.getDiscriminant() >= 0) {
            System.out.println("result number 1: " + quadraticEquation.getRoot1() + "\n result number 2 : " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("result number 1 : " + quadraticEquation.getRoot1() + "\n result number 2 : " + quadraticEquation.getRoot2());
        } else {
            System.out.println(" no solution");
        }
    }
}
