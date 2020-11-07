package pl.sda.bootcamp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.bootcamp.model.Trainer;
import pl.sda.bootcamp.repository.TrainerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public void save(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public List<Trainer> getTrainerList(){
        return trainerRepository.findAll();
    }
}
