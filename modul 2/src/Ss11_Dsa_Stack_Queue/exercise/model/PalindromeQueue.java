package Ss11_Dsa_Stack_Queue.exercise.model;

import My_Method.Array;

import java.util.*;

public class PalindromeQueue {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap chuoi so ");
        String s = scanner.nextLine();
        for (int i = s.length()-1; i >=0; i--) {
            queue.add(s.charAt(i));
        }
//        for (int i = 0; i < s.length(); i++) {
//            System.out.print(arrayDeque.poll());
//        }
        String strings ="";
        while (!queue.isEmpty()){
            strings = strings + queue.remove();
        }
        if (s.equals(strings)) {
            System.out.println(" la chuoi palindrome ");
        } else {
            System.out.println(" ko la chuoi palindrome ");

        }

    }


//        System.out.print("Nhập vào chuỗi cần kiểm tra:");
//        Scanner in = new Scanner(System.in);
//        String inputString = in.nextLine();
//        Queue queue = new LinkedList();
//        for (int i = inputString.length() - 1; i >= 0; i--) {
//            queue.add(inputString.charAt(i));
//        }
//        String reverseString = "";
//        while (!queue.isEmpty()) {
//            reverseString = reverseString + queue.remove();
//        }
//        if (inputString.equals(reverseString))
//            System.out.println("Đây là chuỗi Palindrome");
//        else
//            System.out.println("Đây không phải là chuỗi Palindrome.");
//    }
}

