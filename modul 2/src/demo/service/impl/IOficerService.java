package demo.service.impl;

import demo.model.Oficer;
import demo.service.IServiceOficer;

import java.util.ArrayList;
import java.util.Scanner;

public class IOficerService implements IServiceOficer {
    Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Oficer> oficerArrayList = new ArrayList<Oficer>();

    static {
        oficerArrayList.add(new Oficer(1, "duc", true, "dn", "1999", "Công nghệ thông tin", "aaa", 4.5, 10));
        oficerArrayList.add(new Oficer(1, "hoa", false, "dn", "1999", "Công nghệ thông tin", "aaa", 5, 12));
        oficerArrayList.add(new Oficer(1, "hue", false, "dn", "1999", "Công nghệ thông tin", "aaa", 6, 15));
        oficerArrayList.add(new Oficer(1, "yen", false, "dn", "1999", "aaa", "aaa", 5.5, 15));
    }

    @Override
    public void dispaly() {
        for (Object s : oficerArrayList) {
            System.out.println(s);
        }
    }


    @Override
    public void add() {
        dispaly();
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("gioi tinh");
        boolean gioitinh = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("nhập que quan");
        String queQuan = scanner.nextLine();
        System.out.println("nhập ngay sinh");
        String ngaySinh = scanner.nextLine();
        System.out.println("nhập chuyen mon");
        String chuyenMon = scanner.nextLine();
        System.out.println(" nhap trinh do");
        String trinhDo = scanner.nextLine();
        System.out.println(" nhap he so luong");
        int heSoLuong = Integer.parseInt(scanner.nextLine());
        System.out.println(" nhap phu cap");
        int phuCap = Integer.parseInt(scanner.nextLine());
        Oficer oficer = new Oficer(id, name, gioitinh, queQuan, ngaySinh, chuyenMon, trinhDo, heSoLuong, phuCap);
        // them mới dùng add()
        oficerArrayList.add(oficer);
        dispaly();
    }

    @Override
    public void edit() {
    }

    @Override
    public void delete() {
    }

    @Override
    public void searchByGender(String name) {

    }

    @Override
    public void listedByMoney() {
        dispaly();
        System.out.println("---------------------------------------------");
        for (int i = 0; i < oficerArrayList.size(); i++) {
            if (oficerArrayList.get(i).getThuclinh() < 8000000) {
                System.out.println(oficerArrayList.get(i));
            }
        }

    }

    @Override
    public void countWomen() {
        dispaly();
        System.out.println("---------------------------------------------");
        int count =0;
        for (int i = 0; i < oficerArrayList.size(); i++) {
            if (oficerArrayList.get(i).isGioiTinh() ==false) {
                System.out.println("danh sanh phu nu la "+ oficerArrayList.get(i) );
                count ++;
            }
        }
        System.out.println(" co tong la " + count);
    }

    @Override
    public void sumMoney() {

        dispaly();
        System.out.println("---------------------------------------------");
        int sum =0;
        for (int i = 0; i < oficerArrayList.size(); i++) {
            sum += oficerArrayList.get(i).getThuclinh();
        }
        System.out.println(" co tong la " + sum);
    }

    @Override
    public void listBySpecialize() {
        dispaly();
        System.out.println("---------------------------------------------");
        for (int i = 0; i < oficerArrayList.size(); i++) {
            if (oficerArrayList.get(i).getChuyenMon().equals("Công nghệ thông tin")) {
                System.out.println("danh sanh Công nghệ thông tin la "+ oficerArrayList.get(i) );
            }
        }
    }

    @Override
    public void sort() {

    }
}
