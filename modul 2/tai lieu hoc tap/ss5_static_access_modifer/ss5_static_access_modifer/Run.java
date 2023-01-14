package ss5_static_access_modifer;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        displayMenu();
    }

    public static  void displayMenu(){
        StudentManager studentManager = new StudentManager();
        boolean flag =true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display" +
                    "\n 2. Add" +
                    "\n 3.Delete" +
                    "\n 4. Edit" +
                    "\n 5. Search" +
                    "\n 6. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // code display
                    System.out.println("chức năng hiện thị");
                    studentManager.display();
                    break;
                case 2:
                    // code thêm mới
                    System.out.println("Chức năng thêm ới");
                    studentManager.add();
                    break;
                case 3:
                    // code xóa
                    System.out.println("chức năng xóa");
                    break;
                case 4:
                    // code sửa
                    System.out.println("chức năng sửa");
                    break;
                case 5:
                    // code tìm kiếm
                    System.out.println("chức năng tìm kiếm");
                    break;
                default:
                    flag=false;
            }
        }while (flag);
    }


}
