package shapes;

public class PentagonalPrism extends Shape {
    double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public PentagonalPrism(String name, double side, double height) {
        super(name, height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return side * height;
    }

    @Override
    public double calcBaseArea() {
        return side * height;
    }

    @Override
    public String toString() {
        return super.toString() + "Side: " + side + "\n";
    }
}
