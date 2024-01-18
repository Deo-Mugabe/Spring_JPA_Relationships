package org.deomugabe.jpa_relationships.student.repository;

import org.deomugabe.jpa_relationships.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
