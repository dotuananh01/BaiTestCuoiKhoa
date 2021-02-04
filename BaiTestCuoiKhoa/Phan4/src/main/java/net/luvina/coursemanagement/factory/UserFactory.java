package net.luvina.coursemanagement.factory;

import net.luvina.coursemanagement.dto.UserDto;
import net.luvina.coursemanagement.entity.Student;
import net.luvina.coursemanagement.entity.Teacher;
import net.luvina.coursemanagement.entity.User;
import net.luvina.coursemanagement.enums.UserMode;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User createUser(UserDto dto) {
        if (dto.getMode() == UserMode.TEACHER) {
            return createTeacher(dto);
        } else if (dto.getMode() == UserMode.STUDENT) {
            return createStudent(dto);
        } else {
            throw new UnsupportedOperationException("Unspported register mode");
        }
    }

    public User createTeacher(UserDto dto) {
        return new Teacher(dto);
    }

    public User createStudent(UserDto dto) {
        return new Student(dto);
    }
}
