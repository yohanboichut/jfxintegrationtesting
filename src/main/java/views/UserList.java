package views;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class UserList {

    Stage stage;

    @FXML
    ListView<User> listView;
    private Scene scene;

    public static UserList create(Stage stage, Controller controller) {
        try {

            URL location = UserList.class.getResource("/views/userlist.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);

            Parent parent = fxmlLoader.load();
            UserList view = fxmlLoader.getController();
            view.stage = stage;
            view.controller = controller;
            stage.setTitle("Delete a user");
            view.setScene(new Scene(parent));
            return view;
        }

        catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public void setListViewContent(Collection<User> list) {

        this.listView.getItems().setAll(list);
        this.listView.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            public ListCell<User> call(ListView<User> param) {
                ListCell<User> cell = new ListCell<User>(){
                    @Override
                    protected void updateItem(User t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getLastName() + " - " + t.getFirstName());
                        }
                    }
                };
                return cell;
            }
        });
        this.show();

    }

    public void delete(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Do you really want to delete the user?",
                ButtonType.APPLY,ButtonType.CANCEL);
        Button applyButton = (Button) alert.getDialogPane().lookupButton(ButtonType.APPLY);
        applyButton.setOnAction(event -> controller.deleteUser(listView.getSelectionModel().getSelectedItem().getId()));

        applyButton.setText("Confirm");

        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText("Cancel");
        applyButton.setId("confirm");
        cancelButton.setId("cancel");

        alert.show();


    }
    @FXML
    Button delete;

    @FXML
    Button menu;

    Controller controller;


    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void show() {
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void menu(ActionEvent actionEvent) {
        controller.run();
    }
}
