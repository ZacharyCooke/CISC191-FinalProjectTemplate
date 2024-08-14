package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.services.FitnessService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpa1Application extends Application {
    public ConfigurableApplicationContext springContext;


    public static void main(String[] args) {
        launch(SpringJpa1Application.class, args);
    }

    @Override
    public void start(Stage primaryStage)  {
        FitnessService fitnessService = springContext.getBean(FitnessService.class);
    }

    @Override
    public void stop()   {
        springContext.stop();
    }

    @Override
    public void init()   {
        springContext = SpringApplication.run(SpringJpa1Application.class);
    }
}
