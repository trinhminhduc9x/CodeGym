package Ss15_su_ly_va_debug.practice;

public class Triangle extends IllegalArgumentException {
    private double a, b, c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) throws IllegalTriangleExceptionTest {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleExceptionTest(" canh ko duoc be hon hoac bang ko ");
        } else if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalTriangleExceptionTest(" tong 2 canh lon hon canh con lai");
        }
//        else if (NumberFormatException a) {
//            System.out.println("Nhap so vao thang ngu");
//        }
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void check(int a, int b , int c) throws IllegalTriangleExceptionTest {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleExceptionTest(" canh ko duoc be hon hoac bang ko ");
        } else if (a + b <= c || a + c <= b || c + b <= a) {
            throw new IllegalTriangleExceptionTest(" tong 2 canh lon hon canh con lai");
        }else {
            setA(a);
            setB(b);
            setC(c);
        }
    }
}
