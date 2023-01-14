package Ss15_su_ly_va_debug.practice;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayIndex {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }
    public static void main(String[] args) {
        ArrayIndex arrExample = new ArrayIndex();
        Integer[] arr = arrExample.createRandom();
        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");

        try {
            int x = scaner.nextInt();
            System.out.println("Giá trị của phần tử có chỉ số 5" + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        } catch (Exception e) {
            System.err.println("Chỉ số koo phai la so");
        }
    }
}