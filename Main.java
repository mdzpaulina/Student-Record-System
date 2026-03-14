import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> gradeList = new ArrayList<>();
    static HashMap<String, Double> gradeMap = new HashMap<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 5) {
            printMenu();
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.\n");
                scanner.next();
                continue;
            }

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerStudent(scanner);
                case 2 -> viewGrades();
                case 3 -> viewStatistics();
                case 4 -> searchStudent(scanner);
                case 5 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid option. Please choose between 1 and 5.\n");
            }
        }

        scanner.close();
    }

    // MENU

    /**
     * Displays the main menu with available options.
     */
    static void printMenu() {
        System.out.println("STUDENT SYSTEM");
        System.out.println("1. Register students            ");
        System.out.println("2. View grades                  ");
        System.out.println("3. View statistics              ");
        System.out.println("4. Search student               ");
        System.out.println("5. Exit                         ");
    }

    // REGISTER STUDENT

    /**
     * Registers a new student with name, age, grade, and type (Regular or Scholarship).
     */
    static void registerStudent(Scanner scanner) {
        System.out.println("\n--- Register Student ---");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty. Registration cancelled.");
            return;
        }

        if (gradeMap.containsKey(name)) {
            System.out.println("A student with that name already exists.");
            return;
        }

        System.out.print("Enter age: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid age. Registration cancelled.");
            scanner.next();
            return;
        }
        int age = scanner.nextInt();
        scanner.nextLine();

        double grade = -1;
        while (grade < 0.0 || grade > 10.0) {
            System.out.print("Enter grade (0.0 - 10.0): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid grade. Please enter a number.");
                scanner.next();
                continue;
            }
            grade = scanner.nextDouble();
            scanner.nextLine();
            if (grade < 0.0 || grade > 10.0) {
                System.out.println("Grade must be between 0.0 and 10.0.");
            }
        }

        System.out.println("Student type:");
        System.out.println("  1. Regular");
        System.out.println("  2. Scholarship");
        System.out.print("Choose type: ");

        int type = scanner.hasNextInt() ? scanner.nextInt() : 1;
        scanner.nextLine();

        Student student;
        if (type == 2) {
            student = new ScholarshipStudent(name, age, grade);
        } else {
            student = new RegularStudent(name, age, grade);
        }

        students.add(student);
        names.add(name);
        gradeList.add(grade);
        gradeMap.put(name, grade);

        System.out.println("Student registered successfully!");
        student.displayInfo(true);
        System.out.println("Type: " + student.getType());
    }

    // VIEW GRADES

    /**
     * Displays all registered students sorted by grade in descending order.
     */
    static void viewGrades() {
        if (students.isEmpty()) {
            System.out.println("\nNo students registered yet.");
            return;
        }

        Collections.sort(students, (a, b) -> Double.compare(b.getGrade(), a.getGrade()));

        System.out.println("\n--- Student Grades (sorted by grade) ---");
        System.out.printf("%-5s %-20s %-5s %-8s %-12s %-12s%n",
                "#", "Name", "Age", "Grade", "Status", "Type");
        System.out.println("─".repeat(67));

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%-5d %-20s %-5d %-8.2f %-12s %-12s%n",
                    i + 1,
                    s.getName(),
                    s.getAge(),
                    s.getGrade(),
                    s.getStatus(),
                    s.getType());
        }
    }

    // VIEW STATISTICS

    /**
     * Displays class statistics including average, highest/lowest grades, and pass/fail counts.
     */
    static void viewStatistics() {
        if (gradeList.isEmpty()) {
            System.out.println("\nNo students registered yet.");
            return;
        }

        double[] grades = toArray(gradeList);

        System.out.println("\n--- Class Statistics ---");
        System.out.printf("Total students  : %d%n", grades.length);
        System.out.printf("Average grade   : %.2f%n", calculateAverage(grades));
        System.out.printf("Highest grade   : %.2f%n", highestGrade(grades));
        System.out.printf("Lowest grade    : %.2f%n", lowestGrade(grades));
        System.out.printf("Passed          : %d%n", countPassed(grades));
        System.out.printf("Failed          : %d%n", grades.length - countPassed(grades));
    }

    // SEARCH STUDENT

    /**
     * Searches for a student by name and displays their information if found.
     */
    static void searchStudent(Scanner scanner) {
        if (gradeMap.isEmpty()) {
            System.out.println("\nNo students registered yet.");
            return;
        }

        System.out.print("\nEnter student name to search: ");
        String search = scanner.nextLine().trim();

        if (gradeMap.containsKey(search)) {
            double grade = gradeMap.get(search);
            System.out.println("\nStudent found:");
            System.out.printf("Name   : %s%n", search);
            System.out.printf("Grade  : %.2f%n", grade);
            System.out.printf("Status : %s%n", getStatus(grade));
        } else {
            System.out.println("Student \"" + search + "\" not found.");
        }
    }

    // UTILITY METHODS

    /**
     * Recursively sums all grades in the array starting from index i.
     */
    static double sumGrades(double[] grades, int i) {
        if (i == grades.length) return 0;
        return grades[i] + sumGrades(grades, i + 1);
    }

    /**
     * Calculates the average grade from an array of grades.
     */
    static double calculateAverage(double[] grades) {
        if (grades.length == 0) return 0;
        return sumGrades(grades, 0) / grades.length;
    }

    /**
     * Returns the pass/fail status based on a grade (Passed if >= 6.0, Failed otherwise).
     */
    static String getStatus(double grade) {
        return grade >= 6.0 ? "Passed" : "Failed";
    }

    /**
     * Finds and returns the highest grade in an array of grades.
     */
    static double highestGrade(double[] grades) {
        double max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) max = grades[i];
        }
        return max;
    }

    /**
     * Finds and returns the lowest grade in an array of grades.
     */
    static double lowestGrade(double[] grades) {
        double min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < min) min = grades[i];
        }
        return min;
    }

    /**
     * Counts the number of students who passed (grade >= 6.0).
     */
    static int countPassed(double[] grades) {
        int count = 0;
        for (double g : grades) {
            if (g >= 6.0) count++;
        }
        return count;
    }

    /**
     * Converts an ArrayList of Doubles to a primitive double array.
     */
    static double[] toArray(ArrayList<Double> list) {
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}