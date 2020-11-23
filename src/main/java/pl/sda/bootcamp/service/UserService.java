package pl.sda.bootcamp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.Role;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.repository.CourseRepository;
import pl.sda.bootcamp.repository.RoleRepository;
import pl.sda.bootcamp.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CourseRepository courseRepository;

    public void save(User user){
        userRepository.save(user);
    }


    public List<User> getTrainersList(){
        Role role = roleRepository.findByRoleName("ROLE_TRAINER");
        return userRepository.findByRole(role).stream().distinct().collect(Collectors.toList());
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void delete(Long id){
        List<Course> courseList = courseRepository.findByTrainer_Id(id);
        courseList.forEach(c-> c.setTrainer(null));
        courseRepository.saveAll(courseList);
        userRepository.deleteById(id);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));
    }

    public void updateTrainer(User user){
        courseRepository.findAll().forEach(c->{
            if(user.getTrainerCourses().contains(c)){
                c.setTrainer(user);
            }else if(c.getTrainer() != null && user.getId().equals(c.getTrainer().getId())){
                c.setTrainer(null);
            }
            courseRepository.save(c);
        });
        this.save(user);
    }

    public User getUserByMail(String email){
        return userRepository.findByEmail(email).get();
    }

}
