package edu.sdccd.cisc191.template.services;

import edu.sdccd.cisc191.template.fitness.Fitness;
import edu.sdccd.cisc191.template.fitness.Option;
import edu.sdccd.cisc191.template.repository.OptionRepository;
import edu.sdccd.cisc191.template.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessService {
    @Autowired
    FitnessRepository fitnessRepository;

    @Autowired
    OptionRepository optionRepository;

    public List<Fitness> findAll() {
        return (List<Fitness>) fitnessRepository.findAll();
    }
    public void save(Fitness fitness) {
        fitnessRepository.save(fitness);
    }
    public void save(Option option) {
        optionRepository.save(option);
    }
}

