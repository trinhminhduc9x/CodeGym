package Ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhat {
    public static void main(String[] args) {
        int[] array ;
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(" Nhập số phần tử của mảng");
            size = scanner.nextInt();
            if (size>20){
                System.out.println(" số phần tử của mảng vượt quá số quy định ");
            }
        }while (size>20);
        array = new int[size];
        int i=0 ;
        while (i < array.length){
            System.out.println(" Nhập số phần tử " + (i + 1)+": ");
            array [i] = scanner.nextInt();
            i++;
        }
        System.out.println("Mảng mới nhập là: "+ Arrays.toString(array));
        int min = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j]<min){
                min =array[j];
                index=j+1;
            }
        }
        System.out.println("Số nhỏ nhất là: "+ min + " số thứ tự thứ " + index);
    }
}
