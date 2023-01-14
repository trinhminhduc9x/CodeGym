package Ss14_thuat_toan_sap_xep;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        System.out.println(" nhap  so cac phan tu trong mang ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println(" nhap  phan tu trong mang ");
            integerArrayList.add(Integer.parseInt(scanner.nextLine()));
        }
        insertionSort(integerArrayList);
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
    // cach 2
//    public static void selectionSort2(int [] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int indexMin = i;
//            for (int j = i; j < arr.length; j++) {
//                if (arr[j] < arr[indexMin]) {
//                    indexMin = j;
//                }
//            }
//            System.out.println("Min: " + arr[indexMin]);
//            if (indexMin != i) {
//                int temp = arr[i];
//                arr[i]=arr[indexMin];
//                arr[indexMin]= temp;
//            }
//            System.out.println(" doi cho lan : " + i + " : " + arr[i]);
//        }
//    }
    public static void insertionSort(ArrayList<Integer> arr) {
        int x;
        int pos;

        for (int i = 0; i < arr.size(); i++) {
            x = arr.get(i);
            pos = i;
            //1...4<4
            while (0 < pos && x < arr.get(pos - 1)) {
                arr.set(pos, arr.get(pos - 1));
                pos--;
            }
            arr.set(pos, x);
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(" phan tu mang la " + arr.get(i) + ",");
        }
    }
}
