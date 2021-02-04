package net.luvina.coursemanagement.dto;

import net.luvina.coursemanagement.entity.Student;
import net.luvina.coursemanagement.entity.Teacher;
import net.luvina.coursemanagement.enums.UserMode;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private Student student;
    private Teacher teacher;
    private UserMode mode;
}
