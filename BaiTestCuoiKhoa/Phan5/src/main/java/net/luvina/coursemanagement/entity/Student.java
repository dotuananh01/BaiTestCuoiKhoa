package net.luvina.coursemanagement.entity;

import net.luvina.coursemanagement.dto.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class Student extends User {
    private int year;

    public Student() {
        super();
    }

    public Student(UserDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.year = dto.getStudent().getYear();
    }
}
