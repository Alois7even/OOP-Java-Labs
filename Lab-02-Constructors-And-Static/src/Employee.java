public class Employee {
    private static int nextId = 1;
    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: full
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: no salary yet
    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    // Constructor 3: name only
    public Employee(String name) {
        this(name, "Unassigned");
    }

    // Copy constructor
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);   // gets a NEW id
    }

    public void display() {
        System.out.printf("#%d %s | %s | %.2f%n", employeeId, name, department, salary);
    }

    public static int getTotal() { return nextId - 1; }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tariro", "IT", 1500);
        Employee e2 = new Employee("Farai", "HR");
        Employee e3 = new Employee("Rudo");
        Employee e4 = new Employee(e1);

        e1.display(); e2.display(); e3.display(); e4.display();
        System.out.println("Total employees: " + getTotal());
    }
}