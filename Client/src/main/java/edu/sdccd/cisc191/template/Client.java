import com.sun.glass.ui.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Application {
    private ObjectOutputStream out;
    private ObjectInputStream in;

//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Fitness Program");
//
//        TextField workoutNameField = new TextField();
//        workoutNameField.setPromptText("Workout Name");
//
//        Button addButton = new Button("Add Workout");
//        addButton.setOnAction(e -> addWorkout(workoutNameField.getText()));
//
//        VBox vbox = new VBox(workoutNameField, addButton);
//        Scene scene = new Scene(vbox, 300, 200);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        connectToServer();
//    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 12345);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void addWorkout(String workoutName) {
//        try {
//            out.writeObject("ADD_WORKOUT");
//            out.writeObject(new Workout(workoutName));
//            String response = (String) in.readObject();
//            if (response.equals("WORKOUT_ADDED")) {
//                System.out.println("Workout added successfully.");
//            }
        catch(Exception e) {
            e.printStackTrace();
        }
}

                }