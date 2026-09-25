package net.java.student_management_system.service;

import net.java.student_management_system.dto.StudentDto;

import java.util.List;

/**
 * Service interface defining operations for managing students.
 */
public interface StudentService
{

    /**
     * Retrieves all students.
     * @return a list of all students
     */
    List<StudentDto> getAllStudents();

    /**
     * Creates a new student.
     * @param student the student to create
     */
    void createStudent(StudentDto student);

    /**
     * Retrieves a student by ID.
     * @param id the student ID
     * @return the student with the specified ID
     */
    StudentDto getStudentById(Long id);

    /**
     * Updates an existing student.
     * @param studentDto the updated student data
     */
    void updateStudent(StudentDto studentDto);

    /**
     * Deletes a student by ID.
     * @param studentId the ID of the student to delete
     */
    void deleteStudent(Long studentId);


}
