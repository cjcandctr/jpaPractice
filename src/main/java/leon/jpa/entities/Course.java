package leon.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @SequenceGenerator(
            name="course_seq",
            sequenceName = "course_seq",
            allocationSize = 10
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @Id
    protected Long courseId;
    protected String name;
    protected int credits;

    @OneToOne(
            mappedBy = "course"
    )
    protected CourseMaterial material;

    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "teacher_id_pk",
            referencedColumnName = "id"
    )
    protected Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="student_id",
                    referencedColumnName = "id"
            )
    )
    protected List<Student> students;
    public void addStudents(Student s){
        if(students==null){
            students = new ArrayList<>();
        }
        students.add(s);
    }
}
