package My_Method;

import java.util.Scanner;

public class Search {
    public static int intSearchArr(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập tên cần tìm ");
        int input_name = scanner.nextInt();
        boolean isExist = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == (input_name)) {
                System.out.println("tên của bạn có trong danh sách: " + input_name + " có số thứ tự là : " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println(" không có  " + input_name + " trong danh sách ");
        }
        return input_name;
    }
}
