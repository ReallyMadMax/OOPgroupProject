// package shapes;

// public abstract class Shape implements Comparable<Shape> {
//     public String name;
//     public double height;

//     public abstract double calcVolume();

//     public abstract double calcBaseArea();

//     public double getHeight() {
//         return height;
//     }

//     public void setHeight(double height) {
//         this.height = height;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Shape(String name, double height) {
//         this.name = name;
//         this.height = height;
//     }

//     @Override
//     public String toString() {
//         return "Shape: " + name + "\n" +
//                 "Height: " + height + "\n";
//     }

//     @Override
//     public int compareTo(Shape nextShape) {
//         return Double.compare(this.getHeight(), nextShape.getHeight());
//     }
// }

package shapes;

public abstract class Shape implements Comparable<Shape> {
    public String name;
    public double height;

    public abstract double calcVolume();

    public abstract double calcBaseArea();

    public double volume;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Shape(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Shape: " + name + "\n" +
                "Height: " + height + "\n";
    }

    @Override
    public int compareTo(Shape nextShape) {
        return Double.compare(this.getHeight(), nextShape.getHeight());
    }
}