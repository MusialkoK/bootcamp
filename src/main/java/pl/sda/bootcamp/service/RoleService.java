package pl.sda.bootcamp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.model.Role;
import pl.sda.bootcamp.repository.RoleRepository;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleById(Long id){
        return roleRepository.findById(id).get();
    }

    public Role findByName(String name){
        return roleRepository.findByRoleName(name);
    }
}
