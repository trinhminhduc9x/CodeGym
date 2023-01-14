package My_exercise.ss1.controller;

import My_exercise.ss1.model.Candidate;

import java.util.Arrays;
import java.util.Scanner;

public class MainCandidate {
    public static void displayCandidate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" enter your number  ");
        int number = Integer.parseInt(scanner.nextLine());
        Candidate[] candidates = new Candidate[number];
        for (int i = 0; i < candidates.length; i++) {
            System.out.println("enter id ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("enter name");
            String name = scanner.nextLine();
            System.out.println("enter dateofbrith");
            String dateOfBrith = scanner.nextLine();
            System.out.println("enter MathScores");
            double mathScores = Double.parseDouble(scanner.nextLine());
            System.out.println("enter LiteratureScores");
            double literatureScores = Double.parseDouble(scanner.nextLine());
            System.out.println(" enter EnglishScores");
            double englishScores = Double.parseDouble(scanner.nextLine());
            candidates[i] = new Candidate(id, name, dateOfBrith, mathScores, literatureScores, englishScores);
        }
        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
        Arrays.sort(candidates);
        System.out.println(" ket qua -------------------------------");
        for (Candidate candidate : candidates){
            System.out.println("la "+candidate);
            if (candidate.getSum()>15){
                System.out.println("la "+candidate);
            }

        }
    }
}
