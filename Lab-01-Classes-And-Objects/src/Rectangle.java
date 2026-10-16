public class Rectangle {
    double width, height;

    double area()      { return width * height; }
    double perimeter() { return 2 * (width + height); }

    public static void main(String[] args) {
        double[][] dims = {{2,3},{5,4},{1,9},{6,6},{3,3}};
        Rectangle[] rects = new Rectangle[5];

        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();          // each slot needs its own object
            rects[i].width = dims[i][0];
            rects[i].height = dims[i][1];
        }

        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) largest = r;
        }
        System.out.println("Largest: " + largest.width + " x " + largest.height
                + ", area = " + largest.area());
    }
}