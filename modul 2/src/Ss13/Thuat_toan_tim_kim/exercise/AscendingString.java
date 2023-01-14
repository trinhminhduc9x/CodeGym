package Ss13.Thuat_toan_tim_kim.exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class AscendingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap vao chuoi: ");
        String string = scanner.nextLine();
        ArrayList<Character> maxList = new ArrayList<>();
        ArrayList<Character> Arr = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            Arr.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > Arr.get(Arr.size() - 1)) {
                   Arr.add(string.charAt(j));
                }
            }
            if (Arr.size() > maxList.size()) {
                maxList.clear();
                maxList.addAll(Arr);
            }
            Arr.clear();
        }
        for (Character ch : maxList) {
            System.out.print(ch);
        }
    }
}
