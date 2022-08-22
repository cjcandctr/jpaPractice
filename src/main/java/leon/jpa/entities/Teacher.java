package leon.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    protected String  firstName;
    protected String lastName;

    @Id
    @SequenceGenerator(name="teacher_seq",sequenceName = "teacher_seq")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    protected Long id;

//    @OneToMany(
//    cascade = CascadeType.ALL
//    )
//    @JoinColumn(name="teacher_id_pk", referencedColumnName = "id")
//    List<Course> courseList;
}
