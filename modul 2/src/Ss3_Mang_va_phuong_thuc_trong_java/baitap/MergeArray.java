package Ss3_Mang_va_phuong_thuc_trong_java.baitap;

import My_Method.Array;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = Array.intToArr();
        int[] arr2 = Array.intToArr();
        int[] arr3 = new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
        System.out.println(Arrays.toString(arr3));
    }
}
