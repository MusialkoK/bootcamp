package pl.sda.bootcamp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.dto.CourseDto;
import pl.sda.bootcamp.factory.CourseDtoFactory;
import pl.sda.bootcamp.model.Course;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ApiService {

    private final CourseService courseService;
    private final CourseDtoFactory courseDtoFactory;

    public List<CourseDto> getAllCourses(){
        List<Course> courseList = courseService.getCoursesList();
        return courseList.stream().map(courseDtoFactory::create)
                .collect(Collectors.toList());
    }


    public CourseDto getCourseById(Long id) {
        Course course = courseService.getCourseById(id);
        return courseDtoFactory.create(course);
    }
}
