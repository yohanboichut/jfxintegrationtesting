package controller;

import javafx.stage.Stage;
import model.UserService;
import views.UserList;
import views.Menu;

public class Controller {


    Stage stage;


    UserService userService;
    Menu menu;

    UserList userList;

    public Controller(UserService userService, Stage stage) {
        this.stage = stage;
        
        menu = Menu.create(stage,this);
        userList = UserList.create(stage,this);
        this.userService = userService;

    }


    
    public void run() {
        menu.show();
    }




    public void showUsers() {
        userList.setListViewContent(this.userService.getUsers());
        userList.show();
    }

    public void deleteUser(long selectedId) {
        this.userService.deleteUser(selectedId);
        this.userList.setListViewContent(this.userService.getUsers());
        userList.show();
    }

    public void quit() {
        stage.close();
    }
}
