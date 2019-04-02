package storylines.mocks;

import model.UserService;
import storylines.StorylineFactory;
import storylines.Storyline;

import static functionnalTests.MainTest.SELECT_AUSER_AND_CANCEL;
import static functionnalTests.MainTest.SELECT_AUSER_AND_CONFIRM;

public class StorylineFactoryMocks implements StorylineFactory {


    @Override
    public Storyline getScenario(UserService userService, String cle) {
        switch (cle) {
            case SELECT_AUSER_AND_CANCEL: return new StorylineSelectAUserAndCancelMock(userService);
            case SELECT_AUSER_AND_CONFIRM: return new StorylineSelectAUserAndConfirmMock(userService);
        }
        return null;
    }
}
