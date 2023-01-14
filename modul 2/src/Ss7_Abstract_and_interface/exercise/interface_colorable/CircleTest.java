package Ss7_Abstract_and_interface.exercise.interface_colorable;


class CircleTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1, "do", true);
        shapes[1] = new Rectangle("vang", true, 12, 10);
        shapes[2] = new Square("do", true, 12);
        for (Shape s: shapes) {
            System.out.println(s.getColor());
            if (s instanceof Square){
                ((Square) s).howToColor();
            }
        }
    }
}