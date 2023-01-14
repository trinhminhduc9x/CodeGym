package Ss8_cleanCode_Refactoring.model;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = getVolume(height, baseArea, perimeter);
        return volume;
    }
     private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }


    private static double getVolume(int height, double baseArea, double perimeter) {
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getBaseArea(int radius) {
        double baseArea = Math.PI * radius * radius;
        return baseArea;
}}
