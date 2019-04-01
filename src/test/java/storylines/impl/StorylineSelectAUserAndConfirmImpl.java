package storylines.impl;

import model.User;
import model.UserImpl;
import model.UserService;
import org.easymock.EasyMock;
import storylines.Storyline;

import java.util.ArrayList;
import java.util.Collection;

public class StorylineSelectAUserAndConfirmImpl extends Storyline {
    public StorylineSelectAUserAndConfirmImpl(UserService userService) {
        super(userService);
    }

    @Override
    public void execute() {
        User yohan = new UserImpl("YohanImpl","BoichutImpl");
        User fred = new UserImpl("FredericImpl","MoalImpl");
        this.getUserService().addUser(yohan);
        this.getUserService().addUser(fred);


    }
}
