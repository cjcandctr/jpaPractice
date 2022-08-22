package leon.jpa.repositories;

import leon.jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String name);
    List<Student>  findByFirstNameContaining(String name);
    List<Student> findByGuardianNameNotNull();
    //JPQL
    @Query("select stu from Student stu where stu.email = ?1")
    Student getStudentByEmailAddress(String email);
    @Query("select stu.firstName from Student stu where stu.email = ?1")
    String getStudentNameByEmail(String email);

    @Query(nativeQuery = true,
            value = "select * from student_tb st where st.email_address = ?1"
    )
    Student getStudentByEmailNative(String email);

    @Query("select stu from Student stu where stu.email = :emailId"
    )
    Student getStudentByEmailParam(@Param("emailId") String email);

    @Modifying
    @Query(nativeQuery = true, value = "update student_tb set first_name=?1 where email_address=?2")
    @Transactional
    int updateStudentByEmail(String name, String email);
}
