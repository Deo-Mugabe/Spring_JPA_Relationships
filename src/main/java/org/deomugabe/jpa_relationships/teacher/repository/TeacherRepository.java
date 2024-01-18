package org.deomugabe.jpa_relationships.teacher.repository;

import org.deomugabe.jpa_relationships.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
