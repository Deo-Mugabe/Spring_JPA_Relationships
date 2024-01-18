package org.deomugabe.jpa_relationships.teacher.service;


import org.deomugabe.jpa_relationships.student.service.StudentService;
import org.deomugabe.jpa_relationships.teacher.controller.TeacherController;
import org.deomugabe.jpa_relationships.teacher.dto.CreateTeacher;
import org.deomugabe.jpa_relationships.teacher.dto.TeacherResponse;
import org.deomugabe.jpa_relationships.teacher.entity.Teacher;
import org.deomugabe.jpa_relationships.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<TeacherResponse> getTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherResponse::from)
                .toList();
    }

    @Override
    public TeacherResponse createTeacher(CreateTeacher teacher) {
        Teacher teacher1 = new Teacher();
        teacher1.setName(teacher.getName());
        teacherRepository.save(teacher1);
        return TeacherResponse.from(teacher1);
    }

    @Override
    public TeacherResponse updateTeacher(Long id, CreateTeacher teacher) {
        Optional<Teacher> teacher1 = teacherRepository.findById(id);
        if(teacher1.isPresent()){
            Teacher teacher2 = teacher1.get();
            teacher2.setName(teacher.getName());
            teacherRepository.save(teacher2);
            return TeacherResponse.from(teacher2);
        }
        return null;
        }
    }

