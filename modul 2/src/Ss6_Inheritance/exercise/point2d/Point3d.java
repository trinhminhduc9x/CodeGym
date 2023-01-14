package Ss6_Inheritance.exercise.point2d;

public class Point3d extends Point2d {
    protected float z = 0.0f;

    public Point3d() {
    }

    public Point3d(float z) {
        this.z = z;
    }

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXyz() {
        float []arrXyz = {this.x,this.y,this.z};
        return arrXyz;
    }

    public void setXyz(float x,float y, float z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3d{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

}
