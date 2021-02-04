package net.luvina.coursemanagement.strategy;

import net.luvina.coursemanagement.entity.Course;

import java.util.Comparator;
import java.util.List;

/**
 * Sort by opened descending strategy
 */
public class ByOpenedStrategy implements SortingStrategy {

    @Override
    public void sort(List<Course> courses) {
        courses.sort(Comparator.comparing(Course::getOpened, Comparator.reverseOrder()));
    }

}
