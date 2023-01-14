package Ss7_Abstract_and_interface.exercise.interfac_resizeable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes =new Shape[3];
        shapes[0] = new Circle(1,"do",true);
        shapes[1] = new Rectangle("xanh",true,10,20);
        shapes[2] = new Square("vang",true,10);

    }

}
