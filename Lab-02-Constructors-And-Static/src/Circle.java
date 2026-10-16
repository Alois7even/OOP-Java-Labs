public class Circle {
    private static int count = 0;      // one copy shared by all circles
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);                     // chains to the other constructor; count++ happens there
    }

    public double area() { return Math.PI * radius * radius; }

    public static int getCount() { return count; }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);
        System.out.printf("c1 area = %.2f%n", c1.area());
        System.out.printf("c2 area = %.2f%n", c2.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}