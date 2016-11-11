package stream.student;


public class Student {

    private boolean active;
    private String name;
    private String gender;

    public Student(String name, String gender, boolean active) {
        this.gender = gender;
        this.name = name;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "active=" + active +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
