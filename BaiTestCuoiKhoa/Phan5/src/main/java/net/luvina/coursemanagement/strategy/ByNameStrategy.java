package net.luvina.coursemanagement.strategy;

import net.luvina.coursemanagement.entity.Course;
import java.util.Comparator;
import java.util.List;

/**
 * Sort by age ascending strategy
 */
public class ByNameStrategy implements SortingStrategy {

    @Override
    public void sort(List<Course> courses) {
        courses.sort(Comparator.comparing(Course::getName));
    }

}
