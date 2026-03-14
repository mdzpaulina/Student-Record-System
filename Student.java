public class Student extends Person {

    private double grade;

    public Student(String name, int age, double grade) {
        super(name, age);
        this.grade = grade;
    }

    // Getter & Setter

    /**
     * Returns the student's grade.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the student's grade.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Returns the student's status (Passed if grade >= 6.0, Failed otherwise).
     */
    public String getStatus() {
        return grade >= 6.0 ? "Passed" : "Failed";
    }

    /**
     * Returns the student type (overridden in subclasses).
     */
    public String getType() {
        return "Student";
    }

    /**
     * Displays student information (name and grade).
     */
    public void displayInfo() {
        System.out.printf("Name: %-20s | Grade: %.2f%n", getName(), grade);
    }

    /**
     * Displays student information with optional status display.
     * @param showStatus if true, displays the student's pass/fail status
     */
    public void displayInfo(boolean showStatus) {
        if (showStatus) {
            System.out.printf("Name: %-20s | Grade: %.2f | Status: %s%n",
                    getName(), grade, getStatus());
        } else {
            displayInfo();
        }
    }
}