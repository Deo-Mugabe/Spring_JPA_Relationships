package org.deomugabe.jpa_relationships.subject.dto.request;

import lombok.Data;
import org.deomugabe.jpa_relationships.student.entity.Student;
import org.deomugabe.jpa_relationships.teacher.entity.Teacher;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateSubject {

    private Long id;
    private String name;
    private Set<Student> enrolledStudents = new HashSet<>();
    private Teacher teacher;
}
