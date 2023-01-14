package Ss3_Mang_va_phuong_thuc_trong_java;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTritrongMang {
    public static void main(String[] args) {
        String[] students = { "duc","huy","nghia","vinh","thai"};
        System.out.println("ta có mảng tên là "+Arrays.toString(students));
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập tên cần tìm ");
        String input_name = scanner.nextLine();
        boolean isExist = false ;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)){
                System.out.println("tên của bạn có trong danh sách: " + input_name+ " là : " +(i+1));
                isExist=true;
                break;
            }
        }
        if (!isExist){
            System.out.println(" không có  " +input_name + " trong danh sách ");
        }
    }
}
