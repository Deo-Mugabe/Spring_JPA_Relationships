package org.deomugabe.jpa_relationships.teacher.controller;


import org.deomugabe.jpa_relationships.teacher.dto.CreateTeacher;
import org.deomugabe.jpa_relationships.teacher.dto.TeacherResponse;
import org.deomugabe.jpa_relationships.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> getTeachers(){
        List<TeacherResponse> teacherResponse = teacherService.getTeachers();
        return new ResponseEntity<>(teacherResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestBody CreateTeacher teacher){
        TeacherResponse response = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody CreateTeacher teacher){
        TeacherResponse response = teacherService.updateTeacher(id, teacher);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


}
