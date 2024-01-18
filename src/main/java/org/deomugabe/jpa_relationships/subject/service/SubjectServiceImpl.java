package org.deomugabe.jpa_relationships.subject.service;


import org.deomugabe.jpa_relationships.student.service.StudentService;
import org.deomugabe.jpa_relationships.subject.dto.request.CreateSubject;
import org.deomugabe.jpa_relationships.subject.dto.request.SubjectResponse;
import org.deomugabe.jpa_relationships.subject.entity.Subject;
import org.deomugabe.jpa_relationships.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

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
        subjectRepository.save(subject1);
        return SubjectResponse.from(subject1);
    }

    @Override
    public SubjectResponse updateSubject(Long id, CreateSubject subject) {
        Optional<Subject> subject1 = subjectRepository.findById(id);
        if(subject1.isPresent()){
            Subject subject2 = subject1.get();
            subject2.setName(subject.getName());
            subjectRepository.save(subject2);
            return SubjectResponse.from(subject2);
        }
        return null;
    }
}
