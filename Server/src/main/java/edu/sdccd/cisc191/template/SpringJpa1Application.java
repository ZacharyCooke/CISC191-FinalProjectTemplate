package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.fitness.Fitness;
import edu.sdccd.cisc191.template.fitness.Option;
import edu.sdccd.cisc191.template.repository.FitnessRepository;
import edu.sdccd.cisc191.template.services.FitnessService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpa1Application extends Application {
    public ConfigurableApplicationContext springContext;


    public static void main(String[] args) {
        launch(SpringJpa1Application.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        FitnessService fitnessService = springContext.getBean(FitnessService.class);
        primaryStage.setTitle("Fitness");
        VBox root = new VBox();

        for (Fitness fitness : fitnessService.findAll()) {
            Button btn = new Button();
            btn.setText(fitness.getExerciseName());
            btn.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exercise");
                alert.setHeaderText("Options");
                alert.setContentText(fitness.getOptions().toString());
//                if (optionsText != null && !optionsText.isEmpty()) {
//                    alert.setContentText(optionsText);
//                } else {
//                    alert.setContentText("No options available");
//                }
                alert.showAndWait();
            });
            root.getChildren().add(btn);
        }

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }


    @Override
    public void stop() {
        springContext.stop();
    }

    @Override
    public void init() {
        springContext = SpringApplication.run(SpringJpa1Application.class);
        FitnessService fitness = springContext.getBean(FitnessService.class);
        Option lunges = new Option("lunges");
        fitness.save(lunges);
        Option squats = new Option("squats");
        fitness.save(squats);
        Option jacks = new Option("jacks");
        fitness.save(jacks);
        Option plank = new Option("plank");
        fitness.save(plank);
        Option bench = new Option("bench");
        fitness.save(bench);

        List<Option> options = new ArrayList<>();
        options.add(lunges);
        options.add(squats);
        options.add(jacks);
        options.add(plank);
        options.add(bench);

        Fitness dateOfWorkout;
        dateOfWorkout = new Fitness("lunges", 10, 3, 30, 30, options);
        fitness.save(dateOfWorkout);

        for (Fitness fitness1 : fitness.findAll()) {
            System.out.println(fitness1.toString());
        }
    }


    @Bean
    public Server inMemoryDBServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
