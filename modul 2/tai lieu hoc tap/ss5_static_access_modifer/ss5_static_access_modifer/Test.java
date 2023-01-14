package ss5_static_access_modifer;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student(1,"chanh1","DN",true,"chanhtv","CodeGym");
        Student student2 = new Student(2,"chanh1","DN",true,"chanhtv","CodeGym");
        // truy cấp biến static thông qua tên Class
        Student.school="CodeGym1";
        System.out.println(student1);
        System.out.println(student2);
        // truy cập biến static thông quá đối tượng
        student1.school="BK";
        System.out.println(student1);
        System.out.println(student2);
        // gọi phương thức tiện ích
        // System.out.println(Calculator.sum(3,4));
        // System.out.println(Calculator.multiply(3,4));
        student1.setId(12);
        // không thẻ truy cập ngoài class với private
        // student1.id=23;
        // có thể truy cập với default
        // student1.name="chanh2";
        System.out.println(student1);
    }
}
