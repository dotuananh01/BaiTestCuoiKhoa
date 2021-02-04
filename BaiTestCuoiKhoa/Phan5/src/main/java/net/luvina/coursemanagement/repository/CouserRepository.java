package net.luvina.coursemanagement.repository;

import net.luvina.coursemanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CouserRepository extends JpaRepository<Course, Integer> {
    List<Course> findByName(String name);
}
