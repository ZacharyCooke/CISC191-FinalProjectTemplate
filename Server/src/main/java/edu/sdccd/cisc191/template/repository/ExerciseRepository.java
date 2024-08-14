package edu.sdccd.cisc191.template.repository;


import edu.sdccd.cisc191.template.fitness.Option;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Option, String> {
}
