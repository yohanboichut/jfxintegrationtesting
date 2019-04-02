package storylines.mocks;

import model.UserService;
import model.User;
import org.easymock.EasyMock;
import storylines.Storyline;

import java.util.ArrayList;
import java.util.Collection;


/**
 * A user runs the application, click on *delete a user*, select a user in the listview, click on the delete button and
 * finally cancel his action. The class StoryLineSelectAUserAndCancelMock explicitly defines what we expect about an
 * instance of the type UserService in this storyline.
 */

public class StorylineSelectAUserAndCancelMock extends Storyline {
    public StorylineSelectAUserAndCancelMock(UserService userService) {
        super(userService);
    }


    /**
     * The method execute defines what we expect about a mock of the type UserService in this storyline.
     */

    @Override
    public void execute() {

        /**
         * We define two users that we supposed to have in our user service.
         */
        Collection<User> users = new ArrayList<>();
        User yohan = EasyMock.createMock(User.class);
        User fred = EasyMock.createMock(User.class);
        users.add(yohan);
        users.add(fred);
        EasyMock.expect(getUserService().getUsers()).andReturn(users);


        /**
         * We give some properties to each of these mocks
         */

        EasyMock.expect(yohan.getLastName()).andReturn("BOICHUT").anyTimes();
        EasyMock.expect(yohan.getFirstName()).andReturn("Yohan").anyTimes();


        EasyMock.expect(fred.getLastName()).andReturn("MOAL").anyTimes();
        EasyMock.expect(fred.getFirstName()).andReturn("Fred").anyTimes();

        EasyMock.expect(yohan.getId()).andReturn(0L).anyTimes();


        EasyMock.expect(fred.getId()).andReturn(1L).anyTimes();


        /**
         * The mocks have to be set as ready for this storyline
         */

        EasyMock.replay(yohan,fred, getUserService());

    }
}
