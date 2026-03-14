public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters

    /**
     * Returns the person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the person's age.
     */
    public int getAge() {
        return age;
    }

    // Setters

    /**
     * Sets the person's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the person's age.
     */
    public void setAge(int age) {
        this.age = age;
    }
}