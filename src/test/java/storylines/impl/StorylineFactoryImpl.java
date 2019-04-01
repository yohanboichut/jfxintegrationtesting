package storylines.impl;

import model.UserService;
import storylines.Storyline;
import storylines.StorylineFactory;

import static functionnalTests.MainTest.SELECT_AUSER_AND_CANCEL;
import static functionnalTests.MainTest.SELECT_AUSER_AND_CONFIRM;

public class StorylineFactoryImpl implements StorylineFactory {


    @Override
    public Storyline getScenario(UserService userService, String cle) {
        switch (cle) {
            case SELECT_AUSER_AND_CANCEL: return new StorylineSelectAUserAndCancelImpl(userService);
            case SELECT_AUSER_AND_CONFIRM: return new StorylineSelectAUserAndConfirmImpl(userService);
        }
        return null;
    }
}
