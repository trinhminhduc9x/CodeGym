package Ss14_thuat_toan_sap_xep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        selectionSort(arrayList());
//        selectionSort2(intToArr());
        insertionSort(intToArr());
    }

    public static ArrayList arrayList() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        System.out.println(" nhap  so cac phan tu trong mang ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println(" nhap  phan tu trong mang ");
            integerArrayList.add(Integer.parseInt(scanner.nextLine()));
        }
        return integerArrayList;

    }

    public static int[] intToArr() {
        int[] array;
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập số phần tử của mảng");
        size = scanner.nextInt();
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println(" Nhập số phần tử " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println(" Mảng mới nhập là " + Arrays.toString(array));
        return array;
    }

    //    public static void selectionSort(ArrayList<Integer> arr) {
//        for (int i = 0; i < arr.size(); i++) {
//            int indexMin = i;
//            for (int j = i; j < arr.size(); j++) {
//                if (arr.get(j) < arr.get(indexMin)) {
//                    indexMin = j;
//                }
//            }
//            System.out.println("Min: " + arr.get(indexMin));
//            if (indexMin != i) {
//                int temp = arr.get(i);
//                arr.set(i, arr.get(indexMin));
//                arr.set(indexMin, temp);
//            }
//            System.out.println(" doi cho lan : " + i + " : " + arr.get(i));
//        }
//    }
    public static void insertionSort(int[] arr) {
        int x;
        int pos;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (0 < pos && x < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
            System.out.println("lan thu" + i + ":" + Arrays.toString(arr));
//            System.out.println("lan thu" + i + ":" + arr[i]);
        }
    }

    public static void selectionSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexMin = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            System.out.println("Min: " + arr[indexMin]);
            if (indexMin != i) {
                int temp = arr[i];
                arr[i] = arr[indexMin];
                arr[indexMin] = temp;
            }
            System.out.println(" doi cho lan : " + i + " : " + arr[i]);
        }
    }
}
