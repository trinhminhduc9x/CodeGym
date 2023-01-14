package baiTapThem.service.impl;


import baiTapThem.model.TourCar;
import baiTapThem.service.IServiceCar;
import baiTapThem.utill.ReadAndWriteCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TourCarService implements IServiceCar {

    Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE = "src/baiTapThem/data/TourCarService.csv";

    @Override
    public void add() {
        List<TourCar> tourCarList = new ArrayList<>();
        List<TourCar> tourCarList2 = ReadAndWriteCSV.readTourCarList(PATH_FILE);
        System.out.println("nhập bien kiem soat");
        String bienKiemSoat = scanner.nextLine();
        System.out.println("nhập ten hang san xuat");
        String temHangSanXuat = scanner.nextLine();
        System.out.println(" nhap nam san xuat");
        String namSanXuat = scanner.nextLine();
        System.out.println(" nhap chu so huu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("nhập so cho ngoi ");
        int id = tourCarList2.size() + 1 ;
        System.out.println(" nhap kieu xe");
        String kieuXe = scanner.nextLine();
        TourCar tourCar = new TourCar(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu, id, kieuXe);
        // them mới dùng add()
        tourCarList.add(tourCar);
        ReadAndWriteCSV.writeTourCarListToCSV(tourCarList, PATH_FILE, true);
    }

    @Override
    public void dispaly() {
        List<TourCar> tourCarList = ReadAndWriteCSV.readTourCarList(PATH_FILE);
        for (int i = 0; i < tourCarList.size(); i++) {
            System.out.println((1 + i) + ". " + tourCarList.get(i));
        }
    }

    @Override
    public void delete(String bienSo) {
        List<TourCar> tourCarList = ReadAndWriteCSV.readTourCarList(PATH_FILE);
        for (int i = 0; i < tourCarList.size(); i++) {
            if (bienSo.equals(tourCarList.get(i).getBienKiemSoat())) {
                System.out.println("bạn có chắc chắn xóa không " +
                        "\n 1.yes" +
                        "\n 2.No");
                try {
                    int choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.println("da xoa thanh cong " + tourCarList.get(i));
                            tourCarList.remove(i);
                            ReadAndWriteCSV.writeTourCarListToCSV(tourCarList, PATH_FILE, false);
                            break;
                        case 2:
                            System.out.println("không xóa thoát ra ngoài");
                            break;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(" bạn nhập bị lỗi, yêu cầu nhập đúng cú pháp ");
                }
            }
        }
    }

    @Override
    public void searchByName(String name) {
        List<TourCar> tourCarList = ReadAndWriteCSV.readTourCarList(PATH_FILE);
        int count = 0;
        for (int i = 0; i < tourCarList.size(); i++) {
            if (name.equals(tourCarList.get(i).getBienKiemSoat())) {
                System.out.println(tourCarList.get(i));
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println(" ko co phuong tien duoc tim thay");
        }
    }
}
