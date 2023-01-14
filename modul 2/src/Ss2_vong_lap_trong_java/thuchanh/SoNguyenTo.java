package Ss2_vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class SoNguyenTo {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a number:");
//        int number = scanner.nextInt();
//        if (number < 2){
//            System.out.println(number + " is not a prime");
//        } else {
//            int i = 2;
//            boolean check = true;
//            while (i <= Math.sqrt(number)) {
//                if (number % i == 0) {
//                    check = false;
//                    break;
//                }
//                i++;
//            }
//            if (check)
//                System.out.println(number + " is a prime");
//            else
//                System.out.println(number + " is not a prime");
//        }
//    }
    public static void main(String[] args) {
        System.out.println(" nhap vao so de kiem tra ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;
        if (number > 2) {
            for (int j = 1; j <= number; j++) {
                if (number % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println( number + " là số nguyên tố ");
            } else {
                System.out.println(number + " không phải là số nguyên tố ");
            }
        }

    }
}
