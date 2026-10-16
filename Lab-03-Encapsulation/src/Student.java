public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);          // reuse validation
        setMarks(marks);
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        this.name = name.trim();
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // Computed from marks each time; no grade field to go out of sync
    public String getGrade() {
        if (marks >= 70) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 82);
        Student s2 = new Student("Farai", 55);
        System.out.println(s1.getName() + ": " + s1.getMarks() + " -> " + s1.getGrade());
        System.out.println(s2.getName() + ": " + s2.getMarks() + " -> " + s2.getGrade());

        try {
            s2.setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}