package Ss19_String_Regex.exercise.validatePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ValidatePhoneTest {
    static Scanner scanner = new Scanner(System.in);
    private static ValidatePhone validate;
    public static final List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Add" +
                    "\n 2.Exit");
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("them moi chuoi can ghi");
                    String str = scanner.nextLine();
                    stringList.add(str);
                    break;
                default:
                    flag = false;
            }
        } while (flag);
        validate = new ValidatePhone();
        for (int i = 0; i < stringList.size(); i++) {
            boolean isvalid = validate.validate(stringList.get(i));
            System.out.println("Email is " + stringList.get(i) + " is valid: " + isvalid);
        }

//        System.out.println(" nhap so dt kiem tra");
//        String dt= scanner.nextLine();
//        validate = new ValidatePhone();
//        boolean isvalid = validate.validate(dt);
//        if (isvalid==true){
//            System.out.println(" can nhap lai so ");
//        }else {
//            System.out.println(" so nhap da dung ");
//        }
    }
}