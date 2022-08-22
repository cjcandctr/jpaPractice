package leon.jpa.repositories;

import leon.jpa.entities.Guardian;
import leon.jpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository repo;

    @Test
    void saveStudent(){
        Student s1 = Student.builder().firstName("aaa").lastName("AAA").email("aaa@mail.com").build();
        repo.save(s1);

    }

    @Test
    void saveWithGuardian(){
        Guardian g = Guardian.builder().phone("12355").email("aaaaaaaa@mail.com").name("aaaGG").build();
        Student s = Student.builder().firstName("bbb").lastName("BBB").email("bbb@mail.com").guardian(g).build();
        repo.save(s);
    }

    @Test
    void listAllStudents(){
        List<Student> stus = repo.findAll();
        System.out.println(stus);
    }

    @Test
    void findByPractice(){
        List<Student> ss= repo.findByFirstName("aaa");
        System.out.println(ss);
        List<Student> ss1 =repo.findByFirstName("a");
        System.out.println(ss1);

        List<Student> ss2 = repo.findByGuardianNameNotNull();
        System.out.println(ss2);

        Student stu = repo.getStudentByEmailAddress("bbb@mail.com");
        System.out.println(stu);

        Student stu2 = repo.getStudentByEmailNative("bbb@mail.com");
        System.out.println(stu2);

        Student st3 = repo.getStudentByEmailParam("bbb@mail.com");
        System.out.println(st3);
    }
}