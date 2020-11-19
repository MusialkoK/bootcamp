package pl.sda.bootcamp.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.repository.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public void saveCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getCoursesList(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

}
