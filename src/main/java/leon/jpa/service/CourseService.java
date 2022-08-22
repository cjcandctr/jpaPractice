package leon.jpa.service;

import leon.jpa.dto.CourseDTO;
import leon.jpa.entities.Course;
import leon.jpa.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository repo;
    public List<CourseDTO> getAllCourses(){
        List<Course> list = repo.findAll();
        return list.stream().map(c->{return new CourseDTO(c.getName(), c.getCredits(),c.getTeacher()==null?"":c.getTeacher().getFirstName());}).collect(Collectors.toList());
    }
    public CourseDTO getCourseById(long id){
        Course c=  repo.findById(id).get();
        if(c==null) return null;
        return new CourseDTO(c.getName(),c.getCredits(),c.getTeacher() == null?"":c.getTeacher().getFirstName());
    }

    public CourseDTO getCourseByName(String name){
        Course c=  repo.findByName(name);
        if(c==null) return null;
        return new CourseDTO(c.getName(),c.getCredits(),c.getTeacher() == null?"":c.getTeacher().getFirstName());
    }
}
