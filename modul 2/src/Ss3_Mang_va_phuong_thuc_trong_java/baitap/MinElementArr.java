package Ss3_Mang_va_phuong_thuc_trong_java.baitap;

import My_Method.Array;

import java.util.Arrays;

public class MinElementArr {
        public static void main(String[] args) {
            int[] arr1 = Array.intToArr();
            int[] arr2 = Array.intToArr();
            int[] arr3 = Array.intToArr();
            int[][] arr = {arr1, arr2, arr3};
            System.out.println("arr = [ ");
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr3));
            System.out.println(" ]");
            int min = arr[0][0];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (min>arr[i][j]){
                        min =arr[i][j];
                    }

                }

            }
            System.out.println("min is : "+ min);
        }
}
