package baiTapThem.service.impl;

import baiTapThem.model.Truck;
import baiTapThem.service.IServiceCar;
import baiTapThem.utill.ReadAndWriteCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements IServiceCar {
    private static final String PATH_FILE = "src/baiTapThem/data/truck.csv";
    Scanner scanner = new Scanner(System.in);

    // kiem tra bien so trung lap
    public Boolean kiemTra(String x) {
        List<Truck> truckList = new ArrayList<>();
        boolean flag = true;
        for (Truck s : truckList) {
            if (s.getBienKiemSoat().equals(x)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //Them vao doi tuong
    @Override
    public void add() {
        System.out.println("nhập bien kiem soat");
        String bienKiemSoat = scanner.nextLine();
        if (!kiemTra(bienKiemSoat)) {
            return;
        }
        System.out.println("nhập ten hang san xuat");
        String temHangSanXuat = scanner.nextLine();
        System.out.println(" nhap nam san xuat");
        String namSanXuat = scanner.nextLine();
        System.out.println(" nhap chu so huu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("nhập trong tai ");
        double id = Double.parseDouble(scanner.nextLine());
        Truck truck = new Truck(bienKiemSoat, temHangSanXuat, namSanXuat, chuSoHuu, id);
        // them mới dùng add()
        List<Truck> trucksList = new ArrayList<Truck>();
        trucksList.add(truck);
        ReadAndWriteCSV.writeTruckListToCSV(trucksList, PATH_FILE, true);
    }

    @Override
    public void dispaly() {
        List<Truck> trucksList = ReadAndWriteCSV.readTruckList(PATH_FILE);
        for (int i = 0; i < trucksList.size(); i++) {
            System.out.println((1 + i) + ". " + trucksList.get(i));
        }
    }

    // tim theo
    @Override
    public void searchByName(String name) {
        List<Truck> trucksList = ReadAndWriteCSV.readTruckList(PATH_FILE);
        int count = 0;
        for (int i = 0; i < trucksList.size(); i++) {
            if (name.equals(trucksList.get(i).getBienKiemSoat())) {
                System.out.println(trucksList.get(i));
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println(" ko co phuong tien duoc tim thay");
        }
    }

    //xoa so
    @Override
    public void delete(String bienSo) {
        List<Truck> trucksList = ReadAndWriteCSV.readTruckList(PATH_FILE);
        for (int i = 0; i < trucksList.size(); i++) {
            if (bienSo.equals(trucksList.get(i).getBienKiemSoat())) {
                System.out.println("bạn có chắc chắn xóa không " +
                        "\n 1.yes" +
                        "\n 2.No");
                try {
                    int choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.println("da xoa thanh cong " + trucksList.get(i));
                            trucksList.remove(i);
                            ReadAndWriteCSV.writeTruckListToCSV(trucksList, PATH_FILE, false);
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
}
