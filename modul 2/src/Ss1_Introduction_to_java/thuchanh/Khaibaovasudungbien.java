package Ss1_Introduction_to_java.baitap;

public class Khaibaovasudungbien {
    public static void main(String[] args) {
        int i= 10; // khai báo biến i là kiểu int, kiểu số nguyên có kích thước 4 byte ( 2 mũ 32 ) các giá trị nằm trong khoảng -2 mũ 31 đến 2 mũ 31-1
        float f=20.5f;// khai báo biến f là kiểu số thực có kích thước 4 byte
        double d=20.5;// kiểu số thực có kích thước 8 byte
        boolean b= true;//bao gồm hai giá trị true vs false
        char c='a';//kiểu ký tự unicode có kích thước 2 byte
        String s="Hà Nội"; // kiểu chuỗi
        System.out.println("i = " + i );
        System.out.println("f = " + f );
        System.out.println("d = " + d );
        System.out.println("b = " + b );
        System.out.println("c = " + c );
        System.out.println("s = " + s );
    }
}
