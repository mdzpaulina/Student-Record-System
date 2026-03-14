public class Student extends Person {

    private double grade;

    public Student(String name, int age, double grade) {
        super(name, age);
        this.grade = grade;
    }

    // Getter & Setter

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return grade >= 6.0 ? "Passed" : "Failed";
    }

    public String getType() {
        return "Student";
    }

    public void displayInfo() {
        System.out.printf("Name: %-20s | Grade: %.2f%n", getName(), grade);
    }

    public void displayInfo(boolean showStatus) {
        if (showStatus) {
            System.out.printf("Name: %-20s | Grade: %.2f | Status: %s%n",
                    getName(), grade, getStatus());
        } else {
            displayInfo();
        }
    }
}