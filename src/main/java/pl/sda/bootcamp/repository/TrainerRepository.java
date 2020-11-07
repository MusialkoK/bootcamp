package pl.sda.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.bootcamp.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
