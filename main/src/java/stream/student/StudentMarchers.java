package stream.student;


import stream.Matcher;

public class StudentMarchers {

    public static Matcher<Student> isActive() {
        return Student::isActive;
    }

    public static Matcher<Student> isMale() {
        return student -> "M".equals(student.getGender());
    }
}
