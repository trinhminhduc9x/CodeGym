package ss5_static_access_modifer;
// Class tiện ích
public class Calculator {
    // biến thường
    int x;
    // biến static
    static int y;
    public void test(){
        multiply(3,4);
    }
    public static int sum(int n1, int n2){
       // method static có thể gọi method static
        multiply(n1,2);
        // không gọi trược tiếp được method thường
        // test()
        // gọi được biến tatic
        System.out.println(y);
        // không gọi được biến thường (none-static)
        // System.out.println(x);
        return n1+n2;
    }
    public static int multiply(int n1, int n2){
        return n1*n2;
    }
}
