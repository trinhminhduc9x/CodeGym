package Ss2_vong_lap_trong_java.baitap;

import java.util.Scanner;

public class DisplayImg {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter length");
                    int chieuDai = input.nextInt();

                    System.out.println("enter width ");
                    int chieuRong = input.nextInt();

                    System.out.println("Draw the rectangle");
                    for(int i = 0; i < chieuRong;i++){
                        for(int j = 0;j < chieuDai;j++){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }


                    break;
                case 2:
                    System.out.println("Draw the square triangle");
                    for(int i = 1; i <= 5; i++){
                        for(int j = 1; j < i; j++){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }

                    break;
                case 3:
                    System.out.println("Draw the isosceles triangle");
                    for(int i = 7;i >= 1;i--){
                        for(int j = 1;j <= i;j++){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
