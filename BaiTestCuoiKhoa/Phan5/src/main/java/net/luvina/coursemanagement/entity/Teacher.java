package net.luvina.coursemanagement.entity;

import net.luvina.coursemanagement.dto.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Teacher extends User {
    private String phone;
    private float experiences;

    public Teacher() {
        super();
    }

    public Teacher(UserDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.phone = dto.getTeacher().getPhone();
        this.experiences = dto.getTeacher().getExperiences();
    }

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
