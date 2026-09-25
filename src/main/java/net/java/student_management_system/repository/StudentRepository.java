package net.java.student_management_system.repository;

import net.java.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for accessing and managing student data in the database.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
