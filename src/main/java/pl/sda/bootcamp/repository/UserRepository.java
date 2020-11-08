package pl.sda.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.bootcamp.model.Role;
import pl.sda.bootcamp.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByRole(Role role);
    Optional<User> findById(Long id);


}
