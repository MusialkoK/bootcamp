package pl.sda.bootcamp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.model.Role;
import pl.sda.bootcamp.model.User;
import pl.sda.bootcamp.repository.RoleRepository;
import pl.sda.bootcamp.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public List<User> getTrainersList(){
        Role role = roleRepository.findByRoleName("trainer");
        return userRepository.findByRole(role).stream().distinct().collect(Collectors.toList());
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
