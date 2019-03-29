package views;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Menu {

    Stage stage;
    private Scene scene;

    public static Menu create(Stage stage, Controller controller) {
        try {

            URL location = Menu.class.getResource("/views/menu.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);

            Parent parent = fxmlLoader.load();
            Menu view = fxmlLoader.getController();
            view.stage = stage;
            view.controller = controller;
            stage.setTitle("Main menu");
            view.setScene(new Scene(parent));
            return view;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }




    Controller controller;



    public void show() {

        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void quit(ActionEvent actionEvent) {

        controller.quit();
    }

    public void showUsers(ActionEvent actionEvent) {
        controller.showUsers();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
