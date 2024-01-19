package org.deomugabe.jpa_relationships.student.dto;

import lombok.Data;
import org.deomugabe.jpa_relationships.subject.entity.Subject;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateStudent {
    private Long id;
    private String name;
}
