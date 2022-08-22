package leon.jpa.repositories;

import leon.jpa.entities.Course;
import leon.jpa.entities.CourseMaterial;
import leon.jpa.entities.Teacher;
import org.hibernate.boot.model.source.spi.Sortable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository repo;
    @Autowired
    CourseRepository repo_course;
    @Test
    void saveCourseMat(){
        Course c = Course.builder().credits(100).name("Java").build();
        CourseMaterial material = CourseMaterial.builder().materialAddress("www.google.com").course(c).build();

        repo.save(material);
    }

    @Test
    void printAllCourseMats(){
        List<CourseMaterial> list = repo.findAll();
        System.out.println(list);
    }

    @Test
    void printCourses(){
        List<Course> list = repo_course.findAll();
        System.out.println(list);

        //after add reverse map: mappedBy="course" it gots material
    }

    @Test
    void saveCourseWithTeach(){
        Teacher t2 = Teacher.builder().firstName("leon").build();
        Course c = Course.builder().name("Net").credits(80).teacher(t2).build();
        repo_course.save(c);
    }

    @Test
    void findAllPage(){
        Pageable pg2 = PageRequest.of(1,2);
        long total= repo_course.findAll(pg2).getTotalElements();
        long pages= repo_course.findAll(pg2).getTotalPages();
        List<Course> courses = repo_course.findAll(pg2 ).getContent();
        System.out.println(String.join("-", String.valueOf(total), String.valueOf(pages), courses.toString()));

        Pageable pg3 = PageRequest.of(1,4);
        long total1= repo_course.findAll(pg3).getTotalElements();
        long pages1= repo_course.findAll(pg3).getTotalPages();
        List<Course> courses1 = repo_course.findAll(pg3 ).getContent();
        System.out.println(String.join("-", String.valueOf(total1), String.valueOf(pages1), courses1.toString()));

    }

    @Test
    void findPageSort(){
        Pageable p = PageRequest.of(0, 3, Sort.by("courseId").descending());
        Pageable p2 = PageRequest.of(0, 3, Sort.by("credits").descending().and(Sort.by("courseId")));
        List<Course> cousrs = repo_course.findAll(p2).getContent();
        System.out.println(cousrs);
    }

    @Test
    void jpaGreaterPage(){
        PageRequest p = PageRequest.of(0,5);
        List<Course> ls= repo_course.findByCreditsGreaterThan(80,p).getContent();
        System.out.println(ls);
    }
}