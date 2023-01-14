package My_Method;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteAndAddElementOfArray {


    public static int[] intDeleteAndSortToLeft(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập tên cần xoa ");
        int input_name = scanner.nextInt();
        boolean isExist = false;
        int[] arrayNew = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayNew[i] = array[i];
            if (array[i] == (input_name)) {
                System.out.println("tên của bạn có trong danh sách: " + input_name + " có số thứ tự là : " + (i + 1));
                if (i != (array.length - 1)) {
                    for (int j = i + 1; j < array.length; j++) {
                        arrayNew[i] = array[j];
                        i++;
                        isExist = true;
                    }
                } else {
                    arrayNew[array.length - 1] = 0;
                }
            }
        }
        if (!isExist) {
            System.out.println(" không có  " + input_name + " trong danh sách ");
        }
        System.out.println("Mảng đã thay là : " + Arrays.toString(arrayNew));
        return arrayNew;
    }

    public static int[] intAddAndSortToLeft(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập tên cần thêm ");
        int input_name = scanner.nextInt();
        System.out.println(" nhập số thứ tự cần thêm là ");
        int index_name = scanner.nextInt();
        int[] arrayNew = new int[array.length];
        if (index_name < 0 && index_name > (array.length - 1)) {
            System.out.println("không chèn thêm phần từ vào mảng ");
        }else
        {for (int i = 0; i < array.length; i++) {
            arrayNew[i]=array[i];
                if (i == index_name) {
                    System.out.println("chèn số mới vào danh sách: " + input_name + " có số thứ tự là : " + (i));
                    arrayNew[i]=input_name;
                    for (int j = i + 1; j < array.length; j++) {
                        arrayNew[j] = array[i];
                        i++;
                    }
                }
            }
            System.out.println("Mảng đã thay là : " + Arrays.toString(arrayNew));
        }
        return arrayNew;
    }

}
