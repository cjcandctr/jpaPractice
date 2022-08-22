package leon.jpa.repositories;

import leon.jpa.entities.Course;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByCreditsGreaterThan(int credit, Pageable pr);
    Course findByName(String name);
}
