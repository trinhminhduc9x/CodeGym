package demo.controller.MainStudent;

import demo.service.IService;
import demo.service.impl.StudentService;

import java.util.Scanner;

public class MainStudent  {
    private static StudentService studentServices = new StudentService();
    public static void displayMainMenu(){
        boolean flag =true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display" +
                    "\n 2. Add" +
                    "\n 3.Delete" +
                    "\n 4. Sort" +
                    "\n 5. Edit" +
                    "\n 6. Search" +
                    "\n 7. Exit");
           Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // code display
                    System.out.println("chức năng hiện thị");
                  studentServices.dispaly();
                    break;
                case 2:
                    // code thêm mới
                    System.out.println("Chức năng thêm ới");
                    studentServices.add();
                    break;
                case 3:
                    // code xóa
                    System.out.println("chức năng xóa");
                    studentServices.delete();
                    break;
                case 4:
                    // code sửa
                    studentServices.sort();
                    System.out.println("chức năng sửa");
                    break;
                case 5:
                    // code sửa
                    studentServices.edit();
                    System.out.println("chức năng sửa");
                    break;
                case 6:
                    // code tìm kiếm
                    studentServices.searchByName("Chanh");
                    System.out.println("chức năng tìm kiếm");
                    break;
                default:
                    flag=false;
            }
        }while (flag);
        }
    }

