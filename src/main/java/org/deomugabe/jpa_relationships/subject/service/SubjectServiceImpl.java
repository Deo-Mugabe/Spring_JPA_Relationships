package org.deomugabe.jpa_relationships.subject.service;


import org.deomugabe.jpa_relationships.student.dto.StudentResponse;
import org.deomugabe.jpa_relationships.student.entity.Student;
import org.deomugabe.jpa_relationships.student.repository.StudentRepository;
import org.deomugabe.jpa_relationships.student.service.StudentService;
import org.deomugabe.jpa_relationships.subject.dto.request.CreateSubject;
import org.deomugabe.jpa_relationships.subject.dto.request.SubjectResponse;
import org.deomugabe.jpa_relationships.subject.entity.Subject;
import org.deomugabe.jpa_relationships.subject.repository.SubjectRepository;
import org.deomugabe.jpa_relationships.teacher.entity.Teacher;
import org.deomugabe.jpa_relationships.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<SubjectResponse> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectResponse::from)
                .toList();
    }

    @Override
    public SubjectResponse createSubject(CreateSubject subject) {
        Subject subject1 = new Subject();
        subject1.setName(subject.getName());
        subject1.setEnrolledStudents(subject.getEnrolledStudents());
        subject1.setTeacher(subject.getTeacher());
        subjectRepository.save(subject1);
        return SubjectResponse.from(subject1);
    }

    @Override
    public SubjectResponse updateSubject(Long id, CreateSubject subject) {
        Optional<Subject> subject1 = subjectRepository.findById(id);
        if(subject1.isPresent()){
            Subject subject2 = subject1.get();
            subject2.setName(subject.getName());
            subject2.setEnrolledStudents(subject.getEnrolledStudents());
            subject2.setTeacher(subject.getTeacher());
            subjectRepository.save(subject2);
            return SubjectResponse.from(subject2);
        }
        return null;
    }

    @Override
    public SubjectResponse enrollStudentToSubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        subjectRepository.save(subject);
        return SubjectResponse.from(subject);
    }

    @Override
    public SubjectResponse assignTeacherToSubject(Long subjectId, Long teacherId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.assginTeacher(teacher);
        subjectRepository.save(subject);
        return SubjectResponse.from(subject);
    }
}
