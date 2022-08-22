package leon.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;

@Entity
@Table(name="student_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(name="stu_sequence", sequenceName = "stu_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_sequence")
    protected long id;
    protected String firstName;
    protected String lastName;
    @Column(name="email_address", unique = true, nullable = false)
    protected String email;

    @Embedded
    protected Guardian guardian;
}
