package net.java.student_management_system.service.impl;

import net.java.student_management_system.dto.StudentDto;
import net.java.student_management_system.entity.Student;
import net.java.student_management_system.repository.StudentRepository;
import net.java.student_management_system.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the StudentService interface for managing students.
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents()
    {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map((student) -> modelMapper.map(student, StudentDto.class))
                .toList();
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto student)
    {
        Student newStudent = modelMapper.map(student, Student.class);
        studentRepository.save(newStudent);

    }

    @Override
    public StudentDto getStudentById(Long id)
    {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto)
    {
        studentRepository.save(modelMapper.map(studentDto, Student.class));

    }

    @Override
    public void deleteStudent(Long studentId)
    {
        studentRepository.deleteById(studentId);

    }
}
