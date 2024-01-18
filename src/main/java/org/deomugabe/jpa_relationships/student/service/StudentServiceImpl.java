package org.deomugabe.jpa_relationships.student.service;


import org.deomugabe.jpa_relationships.student.dto.CreateStudent;
import org.deomugabe.jpa_relationships.student.dto.StudentResponse;
import org.deomugabe.jpa_relationships.student.entity.Student;
import org.deomugabe.jpa_relationships.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponse::from)
                .toList();
    }

    @Override
    public StudentResponse createStudent(CreateStudent createStudent) {
        Student student = new Student();
        student.setName(createStudent.getName());
        studentRepository.save(student);

        return StudentResponse.from(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, CreateStudent student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student1 = optionalStudent.get();
            student1.setName(student.getName());
            studentRepository.save(student1);
            return StudentResponse.from(student1);
        }
        return null;
    }
}
