package net.luvina.coursemanagement.service;

import net.luvina.coursemanagement.dto.CourseResponseDto;
import net.luvina.coursemanagement.entity.Course;
import net.luvina.coursemanagement.repository.CouserRepository;
import lombok.RequiredArgsConstructor;
import net.luvina.coursemanagement.strategy.ByNameStrategy;
import net.luvina.coursemanagement.strategy.ByOpenedStrategy;
import net.luvina.coursemanagement.strategy.SortingStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.Cacheable;


@Service
@RequiredArgsConstructor
public class CourseService {
    private static Map<String, SortingStrategy> strategies;

    static {
        strategies = new HashMap<String, SortingStrategy>();
        strategies.put("name", new ByNameStrategy());
        strategies.put("opened", new ByOpenedStrategy());
    }

    @Autowired
    private final CouserRepository couserRepository;
    private final ModelMapper modelMapper;

    @Transactional()
    @Cacheable(value = "courses")
    public List<CourseResponseDto> getCourse(String keyword, String sortBy) {
        List<Course> courses = couserRepository.findByName(keyword);
        SortingStrategy sortingStrategy = lookupSortingStrategy(sortBy.toLowerCase());
        sortingStrategy.sort(courses);
        return courses
                .stream()
                .map(c -> modelMapper.map(c, CourseResponseDto.class))
                .collect(Collectors.toList());
    }

    private SortingStrategy lookupSortingStrategy(String strategyName) {
        SortingStrategy sortingStrategy = strategies.get(strategyName);
        if (sortingStrategy == null) {
            throw new UnsupportedOperationException("Unsupported sorting strategy");
        }
        return sortingStrategy;
    }
}
