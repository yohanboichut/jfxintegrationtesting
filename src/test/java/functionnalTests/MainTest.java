package functionnalTests;

import controller.Controller;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import model.ServiceFactory;
import model.User;
import model.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import storylines.StorylineFactory;

import java.util.Collection;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public abstract class MainTest extends ApplicationTest
{


    StorylineFactory storylineFactory;

    public MainTest(ServiceFactory serviceFactory, StorylineFactory storylineFactory) {
        this.serviceFactory = serviceFactory;
        this.storylineFactory = storylineFactory;
    }

    ServiceFactory serviceFactory;
    UserService userService;

    @Override
    public void start(Stage stage) throws Exception {

        laStage = stage;
        stage.toFront();
        userService = serviceFactory.getFacade();
        Controller controller = new Controller(userService,laStage);
        controller.run();
    }
    private void sleepBetweenActions() {

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
    private static final long SLEEP_TIME = 2000;
    Stage laStage;



    public final static String SELECT_AUSER_AND_CANCEL ="selectAUserAndCancel";
    @Test
    public void selectAUserAndCancel() {
       this.storylineFactory.getScenario(userService, SELECT_AUSER_AND_CANCEL).execute();

        sleepBetweenActions();
        clickOn("#delete");
        sleepBetweenActions();

        ListView<User> liste = (ListView<User>) GuiTest.find("#listView");
        sleepBetweenActions();

        liste.getSelectionModel().selectIndices(1);
        User selectedUser = liste.getSelectionModel().getSelectedItem();

        clickOn("#delete");
        sleepBetweenActions();

        sleepBetweenActions();
        clickOn("#cancel");
        sleepBetweenActions();
        Collection<User> resultat = liste.getItems().filtered(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId() == selectedUser.getId();
            }
        });
        Assert.assertFalse(resultat.isEmpty());

    }




    public final static String SELECT_AUSER_AND_CONFIRM ="selectAUserAndConfirm";




    @Test
    public void selectAUserAndConfirm() {

       this.storylineFactory.getScenario(userService, SELECT_AUSER_AND_CONFIRM).execute();
        sleepBetweenActions();
        clickOn("#delete");
        sleepBetweenActions();

        ListView<User> liste = (ListView<User>) GuiTest.find("#listView");
        sleepBetweenActions();

        liste.getSelectionModel().selectIndices(0);
        User selectedUser = liste.getSelectionModel().getSelectedItem();
        sleepBetweenActions();
        clickOn("#delete");
        sleepBetweenActions();
        clickOn("#confirm");
        sleepBetweenActions();

        Collection<User> resultat = liste.getItems().filtered(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId() == selectedUser.getId();
            }
        });
        Assert.assertTrue(resultat.isEmpty());


    }





    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
}
