package org.deomugabe.jpa_relationships.student.dto;

import lombok.Data;
import org.deomugabe.jpa_relationships.student.entity.Student;

@Data
public class StudentResponse {

    private String name;

    public static StudentResponse from(Student student){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.name = student.getName();

        return studentResponse;
    }
}
