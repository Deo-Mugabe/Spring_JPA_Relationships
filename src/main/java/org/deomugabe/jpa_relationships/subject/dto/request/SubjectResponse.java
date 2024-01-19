package org.deomugabe.jpa_relationships.subject.dto.request;

import lombok.Data;
import org.deomugabe.jpa_relationships.student.entity.Student;
import org.deomugabe.jpa_relationships.subject.entity.Subject;
import org.deomugabe.jpa_relationships.teacher.entity.Teacher;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectResponse {

    private Long id;
    private String name;
    private Set<Student> enrolledStudents = new HashSet<>();
    private Teacher teacher;

    public static SubjectResponse from(Subject subject){

        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.id = subject.getId();
        subjectResponse.name = subject.getName();
        subjectResponse.enrolledStudents = subject.getEnrolledStudents();
        subjectResponse.teacher = subject.getTeacher();

        return subjectResponse;
    }
}
