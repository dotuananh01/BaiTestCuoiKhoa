package net.luvina.coursemanagement.dto;

import lombok.Data;

@Data
public class CourseResponseDto {
    private String id;
    private String name;
    private String location;
    private String teacherName;
}
