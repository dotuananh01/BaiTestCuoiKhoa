package net.luvina.coursemanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NamedQuery(name = "Course.findByName", query = "SELECT course FROM Course course WHERE course.name LIKE CONCAT('%',:name,'%')")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String location;
    private String opened;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
