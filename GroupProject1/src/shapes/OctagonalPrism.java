package shapes;

public class OctagonalPrism extends Shape {
    double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public OctagonalPrism(String name, double side, double height) {
        super(name, height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }

    @Override
    public String toString() {
        return super.toString() + "Side: " + side + "\n";
    }
}