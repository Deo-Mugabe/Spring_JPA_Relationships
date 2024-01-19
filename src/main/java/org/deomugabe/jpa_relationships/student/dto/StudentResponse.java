package org.deomugabe.jpa_relationships.student.dto;

import lombok.Data;
import org.deomugabe.jpa_relationships.student.entity.Student;
import org.deomugabe.jpa_relationships.subject.entity.Subject;

import java.util.HashSet;
import java.util.Set;

@Data
public class StudentResponse {
    private Long id;
    private String name;

    public static StudentResponse from(Student student){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.id = student.getId();
        studentResponse.name = student.getName();

        return studentResponse;
    }
}
