public class BlockOrder {
    static { System.out.println("static 1"); }
    { System.out.println("instance 1"); }
    static { System.out.println("static 2"); }
    { System.out.println("instance 2"); }

    BlockOrder() { System.out.println("constructor"); }

    public static void main(String[] args) {
        System.out.println("main starts");
        new BlockOrder();
        new BlockOrder();
    }
}