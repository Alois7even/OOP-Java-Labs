import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {                 // 1. final class: cannot be subclassed
    private final String name;                       // 2. final fields: assigned once
    private final int age;
    private final List<String> hobbies;

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name;
        this.age = age;
        this.hobbies = List.copyOf(hobbies);         // 3. defensive copy on the way in
    }

    public String getName() { return name; }         // 4. getters only, no setters
    public int getAge()     { return age; }
    public List<String> getHobbies() { return hobbies; }   // already immutable, safe to return

    public ImmutablePerson withAge(int newAge) {     // "change" = build a new object
        return new ImmutablePerson(name, newAge, hobbies);
    }

    @Override
    public String toString() { return name + " (" + age + ") " + hobbies; }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Reading", "Chess"));
        ImmutablePerson p = new ImmutablePerson("Tariro", 21, list);

        list.add("Gaming");                          // changing the original list...
        System.out.println(p);                       // ...does not affect p

        ImmutablePerson older = p.withAge(22);
        System.out.println(p.getAge() + " -> " + older.getAge());
    }
}