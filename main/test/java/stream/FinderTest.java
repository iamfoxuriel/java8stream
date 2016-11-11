package stream;

import org.junit.Before;
import org.junit.Test;
import stream.student.Student;

import java.util.ArrayList;
import java.util.List;

import static stream.Finder.find;
import static stream.student.StudentMarchers.isActive;
import static stream.student.StudentMarchers.isMale;

/**
 * Student Matcher Test
 * Created by jadenz on 11/10/2016.
 */
public class FinderTest {
    List<Student> students;

    @Before
    public void setUp() throws Exception {
        Student student1 = new Student("A","M",false);
        Student student2 = new Student("B","M",true);
        Student student3 = new Student("C","F",true);

        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    @Test
    public void test (){
        System.out.println("---------isMale-----------");
        find(students, isMale()).stream().forEach(System.out::println);
        System.out.println("----------isActive------------");
        find(students, isActive()).stream().forEach(System.out::println);
        System.out.println("----------isMale and isActive-------");
        find(students, isMale().and(isActive())).stream().forEach(System.out::println);
        System.out.println("----------isActive and isMale----------");
        find(students, isActive().and(isMale())).stream().forEach(System.out::println);
    }
}
