package Ss11_Dsa_Stack_Queue.exercise.model;

import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        TreeMap<String, Integer> maps = new TreeMap<>();
//        char[] chars = str.toLowerCase().toCharArray();
        String[] strings = str.toLowerCase().split(" ");
        for (String s: strings){
            if (!s.equals(" ")){
                if (maps.containsKey(s)){
                    maps.put(s, maps.get(s)+1);
                }
                else maps.put(s, 1);
            }

        }

        System.out.println(maps.entrySet());
    }
}
