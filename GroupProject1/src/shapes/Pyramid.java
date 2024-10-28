package shapes;

public class Pyramid extends Shape {
    double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Pyramid(String name, double side, double height) {
        super(name, height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3) * calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2);
    }

    @Override
    public String toString() {
        return super.toString() + "Side: " + side + "\n";
    }
}