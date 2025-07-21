package com.student_portal.service;

import com.student_portal.entity.Student;
import com.student_portal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Map<String,String> register(Student student){
        Map<String,String> response=new HashMap<>();
        Student save = studentRepository.save(student);
        if(save!=null){
            response.put("status","registration done");
            return response;
        }
        response.put("status","registration failed");
        return response;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}
