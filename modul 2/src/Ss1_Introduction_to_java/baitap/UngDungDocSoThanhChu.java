package Ss1_Introduction_to_java.baitap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
//    public static void main(String[] args) {
//        Scanner scanner= new Scanner(System.in);
//        System.out.println(" nhập số muốn chuyển thành chữ là");
//        int number = scanner.nextInt();
//        String convertNumberToLetter;
//        String convertNumberToLetter1;
//        if (number<=10){
//            switch (number) {
//                case 0:
//                    convertNumberToLetter = "zezo";
//                    break;
//                case 1:
//                    convertNumberToLetter = "one";
//                    break;
//                case 2:
//                    convertNumberToLetter = "Two";
//                    break;
//                case 3:
//                    convertNumberToLetter = "Three";
//                    break;
//                case 4:
//                    convertNumberToLetter = "Four";
//                    break;
//                case 5:
//                    convertNumberToLetter = "Five";
//                    break;
//                case 6:
//                    convertNumberToLetter = "Six";
//                    break;
//                case 7:
//                    convertNumberToLetter = "Seven";
//                    break;
//                case 8:
//                    convertNumberToLetter = "Eight";
//                    break;
//                case 9:
//                    convertNumberToLetter = "Nine";
//                    break;
//                case 10:
//                    convertNumberToLetter = "Ten";
//                    break;
//                default:
//                    convertNumberToLetter = "";
//        }
//            if (!convertNumberToLetter.equals("")){
//                System.out.printf("The number '%d' to letters is the %s !", number, convertNumberToLetter);}
//            else System.out.print("Invalid input!");
//        }else if ( number<20){
//            int number1= number%10;
//            switch (number1) {
//                case 1:
//                    convertNumberToLetter = "eleven";
//                    break;
//                case 2:
//                    convertNumberToLetter = "twelve";
//                    break;
//                case 3:
//                    convertNumberToLetter = "thirteen";
//                    break;
//                case 4:
//                    convertNumberToLetter = "fourteen";
//                    break;
//                case 5:
//                    convertNumberToLetter = "fifteen";
//                    break;
//                case 6:
//                    convertNumberToLetter = "sixteen";
//                    break;
//                case 7:
//                    convertNumberToLetter = "seventeen";
//                    break;
//                case 8:
//                    convertNumberToLetter = "eighteen";
//                    break;
//                case 9:
//                    convertNumberToLetter = "nineteen";
//                    break;
//                default:
//                    convertNumberToLetter = "";
//            }
//            if (!convertNumberToLetter.equals("")){
//                System.out.printf("The number '%d' to letters is the %s !", number, convertNumberToLetter);}
//            else System.out.print("Invalid input!");
//        }else {
//            int number2 =number / 10;
//            switch (number2) {
//                case 2:
//                    convertNumberToLetter = "twenty";
//                    break;
//                case 3:
//                    convertNumberToLetter = "thirty";
//                    break;
//                case 4:
//                    convertNumberToLetter = "forty";
//                    break;
//                case 5:
//                    convertNumberToLetter = "fifty";
//                    break;
//                case 6:
//                    convertNumberToLetter = "sixty";
//                    break;
//                case 7:
//                    convertNumberToLetter = "seventy";
//                    break;
//                case 8:
//                    convertNumberToLetter = "eighty";
//                    break;
//                case 9:
//                    convertNumberToLetter = "ninety";
//                    break;
//                case 10:
//                    convertNumberToLetter = "one hundred" ;
//                    break;
//                default:
//                    convertNumberToLetter = "";
//            }
//            int number1= number%10;
//
//            switch (number1) {
//                case 0:
//                    convertNumberToLetter1 = "zezo";
//                    break;
//                case 1:
//                    convertNumberToLetter1 = "one";
//                    break;
//                case 2:
//                    convertNumberToLetter1 = "Two";
//                    break;
//                case 3:
//                    convertNumberToLetter1 = "Three";
//                    break;
//                case 4:
//                    convertNumberToLetter1 = "Four";
//                    break;
//                case 5:
//                    convertNumberToLetter1 = "Five";
//                    break;
//                case 6:
//                    convertNumberToLetter1 = "Six";
//                    break;
//                case 7:
//                    convertNumberToLetter1 = "Seven";
//                    break;
//                case 8:
//                    convertNumberToLetter1 = "Eight";
//                    break;
//                case 9:
//                    convertNumberToLetter1 = "Nine";
//                    break;
//                case 10:
//                    convertNumberToLetter1 = "Ten";
//                    break;
//                default:
//                    convertNumberToLetter1 = "";
//            }
//            if (!convertNumberToLetter.equals("")){
//                System.out.printf("The number '%d' to letters is the %s %s !", number, convertNumberToLetter,convertNumberToLetter1);
//            }
//            else System.out.print("Invalid input!");
//        }
//
//    }

    static String tuKhongToiMuoi(int number){
        String convertNumberToLetter = "";
        switch (number) {
                case 0:
                    convertNumberToLetter = "zezo";
                    break;
                case 1:
                    convertNumberToLetter = "one";
                    break;
                case 2:
                    convertNumberToLetter = "Two";
                    break;
                case 3:
                    convertNumberToLetter = "Three";
                    break;
                case 4:
                    convertNumberToLetter = "Four";
                    break;
                case 5:
                    convertNumberToLetter = "Five";
                    break;
                case 6:
                    convertNumberToLetter = "Six";
                    break;
                case 7:
                    convertNumberToLetter = "Seven";
                    break;
                case 8:
                    convertNumberToLetter = "Eight";
                    break;
                case 9:
                    convertNumberToLetter = "Nine";
                    break;
                case 10:
                    convertNumberToLetter = "Ten";
                    break;
                default:
                    convertNumberToLetter = "";
        }
        return convertNumberToLetter;
    }
    static  String tuMuoiMotToiMuoiChin(int number){
        String convertNumberToLetter = "";
        switch (number) {
                case 1:
                    convertNumberToLetter = "eleven";
                    break;
                case 2:
                    convertNumberToLetter = "twelve";
                    break;
                case 3:
                    convertNumberToLetter = "thirteen";
                    break;
                case 4:
                    convertNumberToLetter = "fourteen";
                    break;
                case 5:
                    convertNumberToLetter = "fifteen";
                    break;
                case 6:
                    convertNumberToLetter = "sixteen";
                    break;
                case 7:
                    convertNumberToLetter = "seventeen";
                    break;
                case 8:
                    convertNumberToLetter = "eighteen";
                    break;
                case 9:
                    convertNumberToLetter = "nineteen";
                    break;
                default:
                    convertNumberToLetter = "";
            }
            return convertNumberToLetter;
    }
    static  String soHangChuc(int number){
        String convertNumberToLetter = "";
        switch (number/10) {
                case 2:
                    convertNumberToLetter = "twenty";
                    break;
                case 3:
                    convertNumberToLetter = "thirty";
                    break;
                case 4:
                    convertNumberToLetter = "forty";
                    break;
                case 5:
                    convertNumberToLetter = "fifty";
                    break;
                case 6:
                    convertNumberToLetter = "sixty";
                    break;
                case 7:
                    convertNumberToLetter = "seventy";
                    break;
                case 8:
                    convertNumberToLetter = "eighty";
                    break;
                case 9:
                    convertNumberToLetter = "ninety";
                    break;
                default:
                    convertNumberToLetter = "";
            }
            return convertNumberToLetter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println(" nhap so tu 0 den 999");
            number=scanner.nextInt();
            if (number<0||number>999){
                System.out.println(" da nhap so tu 0 den 999");
            }
        }while (number<0||number>999);
        String chuoi;
        if (number<=10){
            System.out.println(tuKhongToiMuoi(number));
        }else if (number<20){
            System.out.println(tuMuoiMotToiMuoiChin(number));
        }else if (number<100){
            chuoi= soHangChuc(number)+" "+tuKhongToiMuoi(number%10);
            System.out.println(chuoi);
        }else{
            if (number %100 > 19){
                chuoi= tuKhongToiMuoi(number/100) +" hundred and " +soHangChuc(number % 100)+" "+ tuKhongToiMuoi(number%10);
                System.out.println(chuoi);
            }else if (number %100 >10){
                chuoi= tuKhongToiMuoi(number/100) +" hundred and " +soHangChuc(number % 100);
            }else {
                chuoi= tuKhongToiMuoi(number/100) +" hundred and "+ tuKhongToiMuoi(number%10);
            }
            System.out.println(chuoi);
        }
    }
}
