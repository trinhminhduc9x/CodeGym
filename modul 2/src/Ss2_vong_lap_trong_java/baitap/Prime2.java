package Ss2_vong_lap_trong_java.baitap;

public class Prime2 {
    public static boolean TestPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(100 + " prime is : ");
        int dem = 0;
        int i = 2;
        while (dem < 100) {
            if (TestPrime(i)) {
                System.out.print(i + " ");
                dem++;
            }
            i++;
        }
    }
}
