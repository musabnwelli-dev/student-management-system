package net.java.student_management_system.controller;

import jakarta.validation.Valid;
import net.java.student_management_system.dto.StudentDto;
import net.java.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller responsible for handling student-related web requests.
 */
@Controller
public class StudentController
{
    @Autowired
    private StudentService studentService;


    /**
     * Displays a list of all students.
     * @param model the model used to pass data to the view
     * @return the students view
     */
    @GetMapping("/students")
    public String getAllStudents(Model model)
    {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    /**
     * Displays the form for creating a new student.
     * @param model the model used to pass data to the view
     * @return the create student view
     */
    @GetMapping("/student/new")
    public String newStudent(Model model)
    {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create-student";
    }


    /**
     * Creates a new student after validating the submitted data.
     * @param student the student data
     * @param result the validation result
     * @param model the model used to pass data to the view
     * @return a redirect to the student list or the form if validation fails
     */
    @PostMapping("/student")
    public String addStudent(@Valid @ModelAttribute("student") StudentDto student,
                             BindingResult result,
                             Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("student", student);
            return "create-student";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    /**
     * Displays the form for editing an existing student.
     * @param id the ID of the student
     * @param model the model used to pass data to the view
     * @return the edit student view
     */
    @GetMapping("/student/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long id,
                              Model model)
    {
        StudentDto student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    /**
     * Updates an existing student after validating the submitted data.
     * @param studentId the ID of the student
     * @param studentDto the updated student data
     * @param result the validation result
     * @param model the model used to pass data to the view
     * @return a redirect to the student list or the form if validation fails
     */
    @PostMapping("/student/{studentId}")
    public String updateStudent(@PathVariable Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("student", studentDto);
            return "edit-student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";

    }

    /**
     * Deletes a student by ID.
     * @param studentId the ID of the student to delete
     * @return a redirect to the student list
     */
    @GetMapping("/student/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    /**
     * Displays the details of a specific student.
     * @param studentId the ID of the student
     * @param model the model used to pass data to the view
     * @return the student details view
     */
    @GetMapping("/student/{studentId}/view")
    public String viewStudent(@PathVariable Long studentId,
                              Model model)
    {
        StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "view-student";
    }
}
