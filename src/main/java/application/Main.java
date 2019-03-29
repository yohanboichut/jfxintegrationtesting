package application;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.UserService;

public class Main extends Application {



    public void start(Stage primaryStage) throws Exception {

        UserService userService = null;
        Controller controller = new Controller(userService,primaryStage);
        controller.run();
    }
}
