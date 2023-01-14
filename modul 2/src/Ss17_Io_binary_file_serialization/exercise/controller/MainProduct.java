package Ss17_Io_binary_file_serialization.exercise.controller;

import Ss17_Io_binary_file_serialization.exercise.service.impl.IServiceProduct;


import java.util.Scanner;

public class MainProduct {
    Scanner scanner = new Scanner(System.in);
    private static IServiceProduct iServiceProduct = new IServiceProduct();
    public static void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Add" +
                    "\n 2.Display" +
                    "\n 3.Search" +
                    "\n 4.Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng them moi");
                    iServiceProduct.add();
                    break;
                case "2":
                    System.out.println("Chức năng hien thi");
                    iServiceProduct.dispaly();
                    break;
                case "3":
                    System.out.println("chức năng tim");
                    iServiceProduct.searchByName();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
