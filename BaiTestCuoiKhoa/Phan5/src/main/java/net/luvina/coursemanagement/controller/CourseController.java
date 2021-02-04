package net.luvina.coursemanagement.controller;

import net.luvina.coursemanagement.dto.CourseResponseDto;
import net.luvina.coursemanagement.error.ApiError;
import net.luvina.coursemanagement.error.ServiceRuntimeException;
import net.luvina.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CourseController {

    private final CourseService courseService;

    @GetMapping("/api/v1/courses")
    public ResponseEntity<List<CourseResponseDto>> getCourseByName(@RequestParam(value = "keyword") String keyword,
                                                                   @RequestParam(value = "sortBy") String sortBy) {
        List<CourseResponseDto> response = courseService.getCourse(keyword, sortBy);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/v2/courses")
    public ResponseEntity<List<CourseResponseDto>> getCourseByName2(@RequestParam(value = "keyword") String keyword,
                                                                    @RequestParam(value = "sortBy") String sortBy) {
        List<CourseResponseDto> response = courseService.getCourse(keyword, sortBy);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler({ServiceRuntimeException.class})
    public ResponseEntity<ApiError> handleServiceRuntimeException(ServiceRuntimeException ex) {
        ApiError apiError = new ApiError(ex.getErrorCode(), ex.getLocalizedMessage());

        return new ResponseEntity<>(apiError, ex.getHttpStatus());
    }
}
