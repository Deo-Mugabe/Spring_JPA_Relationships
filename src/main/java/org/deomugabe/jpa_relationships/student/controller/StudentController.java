package org.deomugabe.jpa_relationships.student.controller;


import org.deomugabe.jpa_relationships.student.dto.CreateStudent;
import org.deomugabe.jpa_relationships.student.dto.StudentResponse;
import org.deomugabe.jpa_relationships.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.CacheResponse;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        List<StudentResponse> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody CreateStudent createStudent){
        StudentResponse studentResponse = studentService.createStudent(createStudent);
        return new ResponseEntity<>(studentResponse,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody CreateStudent student){
        StudentResponse studentResponse = studentService.updateStudent(id,student);
        return new ResponseEntity<>(studentResponse,HttpStatus.ACCEPTED);

    }

}
