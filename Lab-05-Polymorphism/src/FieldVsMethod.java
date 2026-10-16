class Parent {
    String name = "Parent field";
    String who() { return "Parent method"; }
}

class Child extends Parent {
    String name = "Child field";                 // hides, does not override
    @Override String who() { return "Child method"; }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();                  // declared type Parent, actual type Child
        System.out.println(p.who());             // method: decided at run time
        System.out.println(p.name);              // field: decided at compile time
        System.out.println(((Child) p).name);    // cast changes the declared type
    }
}