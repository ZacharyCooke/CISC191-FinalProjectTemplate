package edu.sdccd.cisc191.template.fitness;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.stream.Collectors;



@Entity
public class Fitness {
    @Id
    private String exerciseName;
    private int sets;
    private int reps;
    private int weight;
    private int duration;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Option> options;

    public Fitness(String exerciseName, int sets, int reps, int weight, int duration, List<Option> options) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.duration = duration;
        this.options = options;
    }
    public Fitness() {}

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Option> getOptions() {
        return options;
    }

    public String getOptionsAsString() {

        return options.stream().map(option -> getOptionsAsString())  .collect(Collectors.joining(", "));
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "exerciseName='" + exerciseName + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", duration=" + duration +
                ", options=" + options +
                '}';
    }
}
