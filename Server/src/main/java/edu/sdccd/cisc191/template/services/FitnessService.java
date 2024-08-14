package edu.sdccd.cisc191.template.services;

import edu.sdccd.cisc191.template.fitness.Fitness;
import edu.sdccd.cisc191.template.repository.ExerciseRepository;
import edu.sdccd.cisc191.template.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessService {
    @Autowired
    FitnessRepository fitnessRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Fitness> findAll() {
        return (List<Fitness>) fitnessRepository.findAll();
    }
}
