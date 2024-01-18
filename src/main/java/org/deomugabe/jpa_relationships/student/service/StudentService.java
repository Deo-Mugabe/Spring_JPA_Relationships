package org.deomugabe.jpa_relationships.student.service;

import org.deomugabe.jpa_relationships.student.dto.CreateStudent;
import org.deomugabe.jpa_relationships.student.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllStudents();

    StudentResponse createStudent(CreateStudent createStudent);

    StudentResponse updateStudent(Long id, CreateStudent student);
}
