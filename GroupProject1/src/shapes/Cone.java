package shapes;

public class Cone extends Shape {
    double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Cone(String name, double radius, double height) {
        super(name, height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return super.toString() + "Radius: " + radius + "\n";
    }
}