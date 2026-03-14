public class RegularStudent extends Student {

    public RegularStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    /**
     * Returns the student type as "Regular".
     */
    @Override
    public String getType() {
        return "Regular";
    }
}