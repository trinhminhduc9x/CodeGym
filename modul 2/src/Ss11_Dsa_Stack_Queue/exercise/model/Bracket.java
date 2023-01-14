package Ss11_Dsa_Stack_Queue.exercise.model;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static boolean testBracket(String s) {
//        Stack<String> stringStack = new Stack<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" nhap bieu thuc kiem tra ");
//        String s = scanner.nextLine();
//        for (int i = 0; i < strings.length(); i++) {
//            stringStack.push(strings.charAt(i)+"");
//        }
//        while (!stringStack.isEmpty()){
//            System.out.print(stringStack.pop());
//        }

        Stack<Character> bStack = new Stack<>();
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char sym = s.charAt(i);

            if (sym == '(') {
                bStack.push(sym);
            }

            if (sym == ')') {
                if (bStack.isEmpty()){
                    return result= false;
                }else {
                    bStack.pop();
                }
            }if (bStack.isEmpty()){
                result= true;
            }else result= false;
        }

        return result;

    }

  public static void main(String[] args) {
          System.out.println(testBracket("()()()()("));
   }
}
