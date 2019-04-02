package storylines.impl;

import model.User;
import model.UserImpl;
import model.UserService;
import org.easymock.EasyMock;
import storylines.Storyline;

import java.util.ArrayList;
import java.util.Collection;


/**
 * A user runs the application, click on *delete a user*, select a user in the listview, click on the delete button and
 * finally cancel his action. The class *StoryLineSelectAUserAndCancelImpl* explicitly defines what we expect about an
 * instance of the type UserService in this storyline.
 */
public class StorylineSelectAUserAndCancelImpl extends Storyline {
    public StorylineSelectAUserAndCancelImpl(UserService userService) {
        super(userService);
    }

    @Override
    public void execute() {
        /**
         * In this method, we define the data that must be in our user service for this storyline.
         **/

        User yohan = new UserImpl("YohanImpl","BoichutImpl");
        User fred = new UserImpl("FredericImpl","MoalImpl");
        this.getUserService().addUser(yohan);
        this.getUserService().addUser(fred);


    }
}
