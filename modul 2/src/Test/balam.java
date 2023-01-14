package Test;

import java.util.Arrays;
import java.util.Scanner;

public class balam {

    public static void main(String[] args) {
        String str = "CodegymDaNang";
        String[] arrstr = str.split("");
      balam ad = new balam();
      ad.sort(arrstr);
//        char c;
//        for (int i = 0; i <str.length() ; i++) {
//            c = str.charAt(i);
//            int j=i-1;
//            if (c>='A'&& c<='Z'){
//// thay vi tri cach vao
//            }
//        }
    }
    public void sort(String array[]) {
        for (int i = 1; i < array.length; i++) {
            String x = array[i];
            // Tìm vị trí để chèn bằng tìm kiếm nhị phân
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            // Chuyển mảng sang đúng một vị trí
            System.arraycopy(array, j, array, j + 1, i - j);

            // Đặt phần tử vào đúng vị trí của nó
            array[j] = x;
        }
    }
}
