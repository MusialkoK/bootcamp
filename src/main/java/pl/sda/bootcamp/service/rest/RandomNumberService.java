package pl.sda.bootcamp.service.rest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class RandomNumberService {

    private final int value = new Random().nextInt();

    public int getValue(){
        return value;
    }
}
