package Ss1_Introduction_to_java.baitap;

import java.util.Scanner;

public class Kiemtranamnhuan {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int year;
        year = scanner.nextInt();
        if (year%4==0){
            if (year%100==0){
                if (year%400==0){
                    System.out.printf("%d is a leap year", year);
                }else {
                    System.out.println("%d is NOT leap year" + year);
                }
            }else {
                System.out.printf("%d is a leap year", year);
            }
        }else {
            System.out.println("%d is NOT leap year" + year);
        }
    }
}
