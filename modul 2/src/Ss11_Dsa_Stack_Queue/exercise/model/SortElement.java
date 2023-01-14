package Ss11_Dsa_Stack_Queue.exercise.model;

import java.util.Scanner;
import java.util.Stack;

public class SortElement {
    //    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i <10 ; i++) {
//            stack.push(i);
//        }
//        int size = stack.size();
//        System.out.println(" kich thuoc " + stack.size());
//        for (int i = 0; i <size ; i++) {
//            System.out.println(" phan tu " + stack.pop());
//        }
//    }
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap chuoi ky tu ");
        String s = scanner.nextLine();
        String[] arr =s.split(" ");
        for (int i = 0; i < arr.length; i++) {
//            stringStack.push(s.charAt(i) + "");
//            System.out.println(arr[i]);
            stringStack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(stringStack.pop() + " " );
        }

    }
}
