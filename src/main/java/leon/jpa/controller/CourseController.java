package leon.jpa.controller;

import leon.jpa.dto.CourseDTO;
import leon.jpa.entities.Course;
import leon.jpa.repositories.CourseRepository;
import leon.jpa.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseService service;

    @GetMapping("courseAll")
    public ResponseEntity<List<CourseDTO>> getAllCourse(){
        log.info("slf4j logging...");
        return new ResponseEntity(service.getAllCourses(), HttpStatus.OK);
    }
    @GetMapping("course/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable long id){

        return new ResponseEntity<>(service.getCourseById(id), HttpStatus.OK);
    }

    @GetMapping("course")
    public ResponseEntity<CourseDTO> getCourseByName(@RequestParam String name, @RequestParam(required =false, defaultValue = "false") boolean like){
        return new ResponseEntity<>(service.getCourseByName(name), HttpStatus.OK);
    }


}
