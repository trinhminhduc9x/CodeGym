package Ss1_Introduction_to_java.baitap;

import java.util.Scanner;

public class Tinhsongaytrongthang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month that you wabt to count days ? ");
        int month = scanner.nextInt();
//
//        switch (month) {
//            case 2:
//                System.out.println(" the month '2' has 28 or 29 day !");
//                break;
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.println(" the month " + month + " has 31 days ");
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.println(" the month " + month + " has 30 days ");
//                break;
//            default:
//                System.out.println(" Invalid input !");
//        }
//        }
//    }


        String daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
        }

        if (!daysInMonth.equals("")){
            System.out.printf("The month '%d' has %s days!", month, daysInMonth);}
        else System.out.print("Invalid input!");
    }}