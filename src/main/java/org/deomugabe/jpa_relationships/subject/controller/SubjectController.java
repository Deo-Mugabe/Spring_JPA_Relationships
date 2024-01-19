package org.deomugabe.jpa_relationships.subject.controller;


import org.deomugabe.jpa_relationships.subject.dto.request.CreateSubject;
import org.deomugabe.jpa_relationships.subject.dto.request.SubjectResponse;
import org.deomugabe.jpa_relationships.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<?> getAllSubjects(){
        List<SubjectResponse> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSubject(@RequestBody CreateSubject subject){
        SubjectResponse subjectResponse = subjectService.createSubject(subject);
        return new ResponseEntity<>(subjectResponse,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id, @RequestBody CreateSubject subject){
        SubjectResponse subjectResponse = subjectService.updateSubject(id,subject);
        return new ResponseEntity<>(subjectResponse,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public ResponseEntity<?> enrollStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId){
        SubjectResponse enroll = subjectService.enrollStudentToSubject(subjectId,studentId);
        return new ResponseEntity<>(enroll,HttpStatus.OK);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public ResponseEntity<?> assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId){
        SubjectResponse enroll = subjectService.assignTeacherToSubject(subjectId,teacherId);
        return new ResponseEntity<>(enroll,HttpStatus.OK);
    }
}
