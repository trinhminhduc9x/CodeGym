package Ss11_Dsa_Stack_Queue.exercise.model;

import java.util.Scanner;
import java.util.Stack;

public class CountElement {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
//        System.out.println(" nhap so ");
//        int number = Integer.parseInt(scanner.nextLine());
//        while (number>0){
//            int number2 = number%2;
//            integerStack.push(number2);
//            number=number/2;
//        }
//        while (!integerStack.isEmpty()){
//            System.out.println(integerStack.pop());
//        }
        System.out.println(" nhap chuoi so nhi phan");
        String s = scanner.nextLine();
        String[] arr = s.split("");
        int number = 0;
        int number2;
        for (int i = 0; i < arr.length; i++) {
            number2 = Integer.parseInt(arr[i]);
            number = number2 + number*2;
        }
        System.out.println(number);

      //  -----------------------------------
//        int number = 0 ;
//        for (int i = 0; i <s.length() ; i++) {
//            stringStack.push(s.charAt(i) + "");
//        }
//
//       while (!stringStack.isEmpty()){
//           System.out.println(stringStack.pop());
//         number=  Integer.parseInt(stringStack.pop()) + number *2;
//       }
//        System.out.println(number);
    }


}
