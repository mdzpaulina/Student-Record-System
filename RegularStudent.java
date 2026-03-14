public class RegularStudent extends Student {

    public RegularStudent(String name, int age, double grade) {
        super(name, age, grade);
    }
    
    @Override
    public String getType() {
        return "Regular";
    }
}