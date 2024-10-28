package shapes;

public class Cylinder extends Shape {
    double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Cylinder(String name, double radius, double height) {
        super(name, height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        double volume = radius * height;
        return volume;
    }

    @Override
    public double calcBaseArea() {
        return radius * height;
    }

    @Override
    public String toString() {
        return super.toString() + "Radius: " + radius + "\n";
    }
}