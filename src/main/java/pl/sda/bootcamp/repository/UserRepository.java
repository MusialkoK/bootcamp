package pl.sda.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.bootcamp.model.Course;
import pl.sda.bootcamp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
