package Ss13.Thuat_toan_tim_kim.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class StringMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> max = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) < list.get(list.size() - 1)) {
                list.clear();
            }
            list.add(string.charAt(i));
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character ch : max) {
            System.out.print(ch);
        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" nhap chuoi bat ky");
//        String str = scanner.nextLine();
//        String[] arrstr = str.split("");
//        String[] arrstr2 = {};
//        System.out.println(Arrays.toString(arrstr));
//        Arrays.sort(arrstr);
//        System.out.println(Arrays.toString(arrstr));
//        for (int j = 1; j < str.length(); j++) {
//            if (arrstr[j].compareTo() ) {
//                arrstr2[j]=arrstr[j];
//            }
//        }
//        for (String ch : arrstr2) {
//            System.out.print(ch);
//        }
    }
}
