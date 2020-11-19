package pl.sda.bootcamp.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.dto.CourseDto;
import pl.sda.bootcamp.dto.UserDto;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class CourseDtoFactory {

    private final UserDtoFactory userDtoFactory;

    public CourseDto create(Course course){
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .city(course.getCity())
                .mode(course.getMode())
                .startDate(course.getStartDate())
                .finishDate(course.getFinishDate())
                .price(course.getPrice())
                .trainer(getTrainer(course))
                .courseUsers(getUsers(course.getUsers()))
                .build();
    }

    private List<UserDto> getUsers(List<User> users) {
        if(isNull(users)){
            return Collections.emptyList();
        }else{
            return users.stream().map(userDtoFactory::create).collect(Collectors.toList());
        }
    }

    private UserDto getTrainer(Course course) {
        return nonNull(course.getTrainer()) ? userDtoFactory.create(course.getTrainer()) : null;
    }

}
