class Address {
    String city;
}

public class Person {
    String name;
    Address address;

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Tariro";
        p.address = new Address();
        p.address.city = "Harare";
        System.out.println(p.name + " lives in " + p.address.city);   // chained dot

        Person q = new Person();       // address was never set, so it is null
        q.name = "Farai";
        if (q.address == null) {
            System.out.println(q.name + " has no address (null check avoided a crash)");
        }
        // System.out.println(q.address.city);  // would throw NullPointerException
    }
}