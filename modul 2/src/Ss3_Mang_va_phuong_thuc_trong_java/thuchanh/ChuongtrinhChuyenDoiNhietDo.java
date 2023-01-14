package Ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class ChuongtrinhChuyenDoiNhietDo {
    public static void main(String[] args) {
        double fahrenheit;
        double celsius;
        int choise ;
        do {
            System.out.println("Menu"
                    +"\n 1.Fahrenheit to Celsius"
                    +"\n 2.Celsius to Fahrenheit"
                    +"\n 0.Exit"
                    +"\n Nhập vào lựa chọn ");
            Scanner scanner = new Scanner(System.in);
            choise = scanner.nextInt();
            System.out.println(choise);
            switch (choise){
                case 1:
                    System.out.println("nhập nhiệt độ F");
                    fahrenheit= scanner.nextDouble();
                    System.out.println(" nhiệt độ C đã chuyển là : " + celsiusToFahrenheit(fahrenheit));
                    break;
                case 2:
                    System.out.println("nhập nhiệt độ C");
                    celsius= scanner.nextDouble();
                    System.out.println(" nhiệt độ F đã chuyển là : " + fahrenheitToCelsius(celsius));
                    break;
                case 0:
                    break;
            }
        }while (choise !=0);

    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0/5)*celsius+32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0/9)*(fahrenheit-32);
        return celsius;
    }
}
