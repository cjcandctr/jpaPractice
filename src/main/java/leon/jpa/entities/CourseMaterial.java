package leon.jpa.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "course")
public class CourseMaterial {
    protected String materialAddress;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long materialId;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "course_id_pk", referencedColumnName = "courseId")
    protected Course course;
}
