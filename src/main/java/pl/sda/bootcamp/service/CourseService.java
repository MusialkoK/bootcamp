package pl.sda.bootcamp.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserService userService;

    public void saveCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getCoursesList(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public boolean deleteCourse(Long id){
        try{
            courseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Course> getTrainerCourses(String username){
        return getCoursesList().stream().filter(c->c.getTrainer().getEmail().equals(username)).collect(Collectors.toList());
    }

    public List<Course> getUserCourses(String username) {
        User user = userService.getUserByMail(username);
        return getCoursesList().stream().filter((c->c.getUsers().contains(user))).collect(Collectors.toList());
    }
}
