package Ss1_Introduction_to_java.baitap;

import java.util.Scanner;

public class UsdToVnd {
    public static void main(String[] args) {
        final int RATE = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter usd ");
        int usd = Integer.parseInt(scanner.nextLine());
       int vnd = usd*RATE;
        System.out.println("  VND : "+ vnd );
    }
}
