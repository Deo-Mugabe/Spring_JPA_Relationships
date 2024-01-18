package org.deomugabe.jpa_relationships.teacher.dto;

import lombok.Data;
import org.deomugabe.jpa_relationships.teacher.entity.Teacher;

@Data
public class TeacherResponse {
    private String name;

    public static TeacherResponse from(Teacher teacher){
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.name = teacher.getName();

        return teacherResponse;
    }
}
