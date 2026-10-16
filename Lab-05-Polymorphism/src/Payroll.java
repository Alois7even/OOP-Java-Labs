class Employee {
    private final String name;
    protected double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    String getName() { return name; }
    double calculatePay() { return baseSalary; }
}

class Manager extends Employee {
    private final double bonus;
    Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }
    @Override double calculatePay() { return super.calculatePay() + bonus; }
}

class Developer extends Employee {
    private final int overtimeHours;
    Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
    @Override double calculatePay() { return baseSalary + overtimeHours * 25.0; }
}

class Intern extends Employee {          // NEW class: the payroll loop is untouched
    Intern(String name, double stipend) { super(name, stipend); }
    @Override double calculatePay() { return baseSalary * 0.5; }   // half-rate stipend
}

public class Payroll {
    public static void main(String[] args) {
        Employee[] staff = {
                new Employee("Kudzai", 2000),
                new Manager("Nyasha", 3500, 800),
                new Developer("Tatenda", 3000, 10),
                new Intern("Chipo", 800)
        };

        double total = 0;
        for (Employee e : staff) {                       // this loop never changes
            System.out.printf("%-8s %.2f%n", e.getName(), e.calculatePay());
            total += e.calculatePay();
        }
        System.out.printf("Total payroll: %.2f%n", total);
    }
}