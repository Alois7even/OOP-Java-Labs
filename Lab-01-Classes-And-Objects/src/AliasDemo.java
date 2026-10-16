public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 4;
        Rectangle r2 = r1;       // copies the reference, not the object
        r2.width = 10;
        System.out.println(r1.width);   // prints 10.0
    }
}