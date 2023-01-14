package Ss2_vong_lap_trong_java.thuchanh;

import java.util.Scanner;

public class TinhLaiNganHang {
    //    public static void main(String[] args) {
//        double money = 1.0;
//        int month = 1;
//        double interestRate = 1.0;
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter investment amount: ");
//        money = input.nextDouble();
//        System.out.println("Enter number of months: ");
//        month = input.nextInt();
//        System.out.println("Enter annual interest rate in percentage: ");
//        interestRate = input.nextDouble();
//        double totalInterest = 0;
//        for(int i = 0; i < month; i++){
//            totalInterest += money * (interestRate/100)/12 * month;
//        }
//        System.out.println("Total of interest: " + totalInterest);
//    }
    public static void main(String[] args) {
        System.out.println(" nhap so tien ");
        Scanner scanner =new Scanner(System.in);
        int money = scanner.nextInt();
        System.out.println(" nhap số tháng đã nợ ");
        Scanner scanner1 =new Scanner(System.in);
        int month = scanner1.nextInt();
        System.out.println(" nhap so lãi ");
        Scanner scanner2 =new Scanner(System.in);
        double interest = scanner2.nextInt();
        int profit = 0;
        for (int i = 0; i < month; i++) {
            profit +=interest/1200 * money*month;
            money = profit + money;
        }
        System.out.println("tổng cả gốc lẫn lãi là " + money);
    }
}
