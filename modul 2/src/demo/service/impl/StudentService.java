package demo.service.impl;

import demo.model.Student;
import demo.service.IService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService implements IService {
    Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> studentsList = new ArrayList<Student>();

    static {
        studentsList.add(new Student(2, "c", "Asd", true, "asd", "b"));
        studentsList.add(new Student(1, "a", "Asd", true, "asd", "a"));
        studentsList.add(new Student(3, "e", "Asd", true, "asd", "c"));
        studentsList.add(new Student(4, "d", "Asd", true, "asd", "d"));
    }

    @Override
    public void dispaly() {
        for (Object s : studentsList) {
            System.out.println(s);
        }
    }

    @Override
    public void add() {
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập ngay xinh");
        String Ngaysinh = scanner.nextLine();
        System.out.println("gioi tinh");
        boolean gioitinh = Boolean.parseBoolean(scanner.nextLine());
        System.out.println(" nhap ten lop");
        String lop = scanner.nextLine();
        System.out.println(" nhap khoa");
        String Khoa = scanner.nextLine();
        Student students = new Student(id, name, Ngaysinh, gioitinh, lop, Khoa);
        // them mới dùng add()
        studentsList.add(students);
    }

    @Override
    public void edit() {
        dispaly();
        System.out.println(" chon hoc vien can sua ");
        int edit = Integer.parseInt(scanner.nextLine());
//        System.out.println("nhập id");
//        int id = Integer.parseInt(scanner.nextLine());
//        System.out.println("nhập tên");
//        String name = scanner.nextLine();
//        System.out.println("nhập ngay xinh");
//        String Ngaysinh = scanner.nextLine();
//        System.out.println(" nhap ngay sinh");
//        boolean gioitinh = Boolean.parseBoolean(scanner.nextLine());
//        System.out.println(" nhap ten lop");
//        String lop = scanner.nextLine();
//        System.out.println(" nhap khoa");
//        String Khoa = scanner.nextLine();
//        Student students = new Student(id, name, Ngaysinh, gioitinh, lop, Khoa);
//        studentsList.set(edit-1,students);
        for (int i = 0; i < studentsList.size(); i++) {
            if (edit - 1 == i) {
                System.out.println("nhập id");
                studentsList.get(i).setMSSV(Integer.parseInt(scanner.nextLine()));
                System.out.println("nhập tên");
                studentsList.get(i).setHoTen(scanner.nextLine());
                System.out.println("nhập ngay xinh");
                studentsList.get(i).setNgaySinh(scanner.nextLine());
                System.out.println(" nhap ngay sinh");
                studentsList.get(i).setGioiTinh(Boolean.parseBoolean(scanner.nextLine()));
                System.out.println(" nhap ten lop");
                studentsList.get(i).setTenLop(scanner.nextLine());
                System.out.println(" nhap khoa");
                studentsList.get(i).setKhoa(scanner.nextLine());
                break;
            }
        }

    }

    @Override
    public void delete() {
        dispaly();
        System.out.println(" nhap hoc vien can xoa");
        int delete = Integer.parseInt(scanner.nextLine());
        studentsList.remove(delete - 1);
    }

    @Override
    public void searchByName(String name) {
        dispaly();
        System.out.println(" nhap hoc vien can tim");
        String s = scanner.nextLine();
        // dieu kien nhap vao la so hay chu
        for (int i = 0; i < studentsList.size(); i++) {
            if (s.equals(studentsList.get(i).getHoTen())) {
                System.out.println(studentsList.get(i));
                break;
            }if (Integer.parseInt(s) == i) {
                System.out.println(studentsList.get(i - 1));
                break;
            }
        }
    }

    @Override
    public void sort() {
        dispaly();
        System.out.println("-------------------------------------------");
//        studentsList.sort(Comparator.comparingInt(Student::getMSSV));
//        studentsList.sort(Comparator.comparing(Student::getHoTen));
        studentsList.sort(Comparator.comparing(Student::getKhoa));
      dispaly();
    }
}


