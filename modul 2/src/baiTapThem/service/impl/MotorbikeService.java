package baiTapThem.service.impl;


import baiTapThem.model.Motorbike;
import baiTapThem.service.IServiceCar;

import java.util.ArrayList;
import java.util.Scanner;

public  class MotorbikeService implements IServiceCar {

    Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Motorbike> motorbikeArrayList = new ArrayList<Motorbike>();

    static {
        motorbikeArrayList.add(new Motorbike("7", "asd", "Asd", "asd", 123));
        motorbikeArrayList.add(new Motorbike("8", "asd", "Asd", "asd", 123));
        motorbikeArrayList.add(new Motorbike("3", "asd", "Asd", "asd", 123));

    }

    @Override
    public void add() {

        System.out.println("nhập bien kiem soat");
        String bienKiemSoat = scanner.nextLine();
        System.out.println("nhập ten hang san xuat");
        String temHangSanXuat = scanner.nextLine();
        System.out.println(" nhap nam san xuat");
        String namSanXuat = scanner.nextLine();
        System.out.println(" nhap chu so huu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("nhập cong suat ");
        int id = Integer.parseInt(scanner.nextLine());
        Motorbike motorbike = new Motorbike(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu, id);
        // them mới dùng add()
        motorbikeArrayList.add(motorbike);
    }

    @Override
    public void dispaly() {
        for (Object s : motorbikeArrayList) {
            System.out.println(s);
        }
    }

    @Override
    public void delete(String a) {
//        for (int i = 0; i < motorbikeArrayList.size(); i++) {
//            if (name.equals(motorbikeArrayList.get(i).getBienKiemSoat())) {
//                System.out.println("Chức năng của hệ thống " +
//                        "\n 1.yes" +
//                        "\n 2.No");
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("Chọn chức năng");
//                int choose = Integer.parseInt(scanner.nextLine());
//                switch (choose) {
//                    case 1:
//                        System.out.println("chức năng them moi");
//                        motorbikeArrayList.remove(i);
//                        System.out.println("da xoa thanh cong");
//                        break;
//                    case 2:
//                        System.out.println("Chức năng hien thi");
//                        break;
//                }
//                break;
//            }
//        }

    }

    @Override
    public void searchByName(String name) {
        int count =0;
        for (int i = 0; i < motorbikeArrayList.size(); i++) {
            if (name.equals(motorbikeArrayList.get(i).getBienKiemSoat())) {
                System.out.println(motorbikeArrayList.get(i));
                count++;
                break;
            }
        }
        if (count==0){
            System.out.println(" ko co phuong tien duoc tim thay");
        }
    }
}
