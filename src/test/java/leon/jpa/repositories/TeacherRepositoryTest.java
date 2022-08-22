package leon.jpa.repositories;

import leon.jpa.entities.Course;
import leon.jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository repo ;

    @Test
    void saveTeacher(){
        Course c1 = Course.builder().credits(50).name("Design1").build();
        Course c2 = Course.builder().credits(70).name("python").build();
        List<Course> list = new LinkedList<>();
        list.add(c1);
        list.add(c2);
//        Teacher t = Teacher.builder().firstName("t3").lastName("t333").courseList(list).build();
//        repo.save(t);

        // after add optional = false for one one mapping, have to add material obj to save course;

    }
}