package demo.controller.MainStudent;

import demo.model.Oficer;
import demo.service.impl.IOficerService;
import demo.service.impl.StudentService;

import java.util.Scanner;

public class MainOficer {
    private static IOficerService iOficerService = new IOficerService();

    public static void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display" +
                    "\n 2. Add" +
                    "\n 3.listedByMoney" +
                    "\n 4. countWomen" +
                    "\n 5. listBySpecialize" +
                    "\n 6. sumMoney" +
                    "\n 7. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    // code display
                    System.out.println("chức năng hiện thị");
                    iOficerService.dispaly();
                    break;
                case 2:
                    // code thêm mới
                    System.out.println("Chức năng thêm ới");
                    iOficerService.add();
                    break;
                case 3:
                    // liet ke danh sach can bo den thoi diem nang luong
                    System.out.println("chức năng list");
                    iOficerService.listedByMoney();
                    break;
                case 4:
                    // code sửa

                    System.out.println("chức năng dem");
                    iOficerService.countWomen();
                    break;
                case 5:
                    // code sửa

                    System.out.println("chức năng Công nghệ thông tin");
                    iOficerService.listBySpecialize();
                    break;
                case 6:
                    // code tìm kiếm
                    System.out.println("chức năng tong");
                    iOficerService.sumMoney();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
