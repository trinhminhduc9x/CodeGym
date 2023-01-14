package Ss7_Abstract_and_interface.exercise.interfac_resizeable;

class CircleTest {
    public static void main(String[] args) {
//        Circle circles = new Circle(1, "do", true);
//        circles.resizeable(3);
//        System.out.println(circles);
//        Shape rectangles = new Rectangle("dd",true,2,3 );
//        System.out.println(rectangles);
//        rectangles.resizeable(2);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1,"do",true);
        shapes[1] = new Rectangle("xx",true,2,3);
        shapes[2] = new Square("nn",true,10);
        for (Shape shape: shapes) {
            System.out.println(shape);
            System.out.println("----------------------------");
        }
        for (Shape shape: shapes) {
            if (shape instanceof Circle){
                ((Circle) shape).resizeable(Math.random()*100);
            } else if (shape instanceof Rectangle){
                ((Rectangle) shape).resizeable(Math.random()*100);
            } else {
                ((Square) shape).resizeable(Math.random()*100);
            }
        }
        System.out.println("-----------------------------");
        for (Shape shape : shapes){
            System.out.println(shape);
            System.out.println("-----------------------");;
        }
    }

}