public class ScholarshipStudent extends Student {

    public ScholarshipStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    /**
     * Returns the student type as "Scholarship".
     */
    @Override
    public String getType() {
        return "Scholarship";
    }
}