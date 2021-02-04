package net.luvina.coursemanagement.strategy;

import net.luvina.coursemanagement.entity.Course;

import java.util.List;

/**
 * Strategy interface
 */
public interface SortingStrategy {

    void sort(List<Course> courses);

}
