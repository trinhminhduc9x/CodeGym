package Ss3_Mang_va_phuong_thuc_trong_java;

import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocCacPhanTuCuaMang {
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
        System.out.println("Mảng mới nhập là: "+Arrays.toString(array));
        for (int j = 0; j< array.length / 2; j ++ ){
            int temp = array[j];
            array[j] = array[size-1-j];
            array[size-1-j]=temp;
        }
        System.out.println("Mảng đã đảo là: "+Arrays.toString(array));
    }
}
