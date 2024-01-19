package org.deomugabe.jpa_relationships.subject.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.deomugabe.jpa_relationships.student.entity.Student;
import org.deomugabe.jpa_relationships.teacher.entity.Teacher;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void assginTeacher(Teacher teacher) {
        this.teacher=teacher;
    }
}
