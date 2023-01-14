package Ss5_Access_modifier_static_method.practice.staticproperty;

public class Car {
    private String name;
    private String engine;
    private static int numberOFCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOFCars++;
    }

    public static int getNumberOFCars() {
        return numberOFCars;
    }
    void display() {
        System.out.println(" name : " + this.name + " engine : " + this.engine);
    }
}
