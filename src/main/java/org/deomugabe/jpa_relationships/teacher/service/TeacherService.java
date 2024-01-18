package org.deomugabe.jpa_relationships.teacher.service;

import org.deomugabe.jpa_relationships.teacher.dto.CreateTeacher;
import org.deomugabe.jpa_relationships.teacher.dto.TeacherResponse;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> getTeachers();

    TeacherResponse createTeacher(CreateTeacher teacher);

    TeacherResponse updateTeacher(Long id, CreateTeacher teacher);
}
