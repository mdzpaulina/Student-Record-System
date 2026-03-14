public class ScholarshipStudent extends Student {

    public ScholarshipStudent(String name, int age, double grade) {
        super(name, age, grade);
    }
    
    @Override
    public String getType() {
        return "Scholarship";
    }
}