package com.student_portal.controller;

import com.student_portal.entity.Student;
import com.student_portal.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "Register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        Map<String, String> status = studentService.register(student);
        model.addAttribute("student", new Student()); // reset form
        model.addAttribute("status", status);
        return "Register";
    }

    @GetMapping("/students")
    public String showStudentList(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "Students";
    }
}
