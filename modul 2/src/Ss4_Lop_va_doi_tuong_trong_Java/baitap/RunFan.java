package Ss4_Lop_va_doi_tuong_trong_Java.baitap;

public class RunFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setColor("Yellow");
        fan1.setRadius(10);
        fan1.setSpeed(fan1.FAST);
        fan1.setOn(true);
        System.out.println(fan1);

        Fan fan2 = new Fan();
        fan2.setColor("Yellow");
        fan2.setRadius(5);
        fan2.setSpeed(fan1.MEDIUM);
        fan2.setOn(false);
        System.out.println(fan2);
    }
}
