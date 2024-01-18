package org.deomugabe.jpa_relationships.subject.service;

import org.deomugabe.jpa_relationships.subject.dto.request.CreateSubject;
import org.deomugabe.jpa_relationships.subject.dto.request.SubjectResponse;

import java.util.List;

public interface SubjectService {
    List<SubjectResponse> getAllSubjects();

    SubjectResponse createSubject(CreateSubject subject);

    SubjectResponse updateSubject(Long id, CreateSubject subject);
}
