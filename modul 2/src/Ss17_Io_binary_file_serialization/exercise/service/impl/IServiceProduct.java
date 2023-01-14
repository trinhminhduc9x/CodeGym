package Ss17_Io_binary_file_serialization.exercise.service.impl;

import Ss17_Io_binary_file_serialization.exercise.model.Product;
import Ss17_Io_binary_file_serialization.exercise.service.IService;
import Ss17_Io_binary_file_serialization.exercise.util.ReadAndWrite;
import baiTapThem.model.Truck;
import baiTapThem.utill.ReadAndWriteCSV;

import java.util.List;
import java.util.Scanner;

public class IServiceProduct implements IService {
    Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE = "src/Ss17_Io_binary_file_serialization/exercise/data/axe.txt";

    @Override
    public void dispaly() {
        List<Product> productList = ReadAndWrite.readDataFromFile(PATH_FILE);
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((1 + i) + ". " + productList.get(i));
        }
    }

    @Override
    public void add() {
        dispaly();
        List<Product> productList =  ReadAndWrite.readDataFromFile(PATH_FILE);
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập ten");
        String ten = scanner.nextLine();
        System.out.println(" nhap hang san xuat");
        String hangSanXuat = scanner.nextLine();
        System.out.println(" nhap gia");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập mo ta khac ");
        String moTa = scanner.nextLine();
        Product product = new Product(id, ten, hangSanXuat, gia, moTa);
        // them mới dùng add()
        productList.add(product);
        ReadAndWrite.writeToFile(PATH_FILE,productList);
    }
    @Override
    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap ten can tim ");
        String name = scanner.nextLine();
        List<Product> productList =  ReadAndWrite.readDataFromFile(PATH_FILE);
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (name.equals(productList.get(i).getName())) {
                System.out.println(productList.get(i));
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println(" ko co phuong tien duoc tim thay");
        }
    }
}
