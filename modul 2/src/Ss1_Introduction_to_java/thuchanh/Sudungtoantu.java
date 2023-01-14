package Ss1_Introduction_to_java.baitap;

import java.util.Scanner;

public class Sudungtoantu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = scanner.nextFloat();// Nhap chieu rong

        System.out.println("Enrer height: ");
        height = scanner.nextByte();// Nhap chieu dai
        float area = width * height;
        System.out.printf("Area is: " + area);
    }
}
