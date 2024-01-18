package org.deomugabe.jpa_relationships.subject.dto.request;

import lombok.Data;
import org.deomugabe.jpa_relationships.subject.entity.Subject;

@Data
public class SubjectResponse {

    private String name;

    public static SubjectResponse from(Subject subject){

        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.name = subject.getName();

        return subjectResponse;
    }
}
