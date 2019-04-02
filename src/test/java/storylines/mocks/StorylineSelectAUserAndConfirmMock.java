package storylines.mocks;

import model.UserService;
import model.User;
import org.easymock.EasyMock;
import storylines.Storyline;

import java.util.ArrayList;
import java.util.Collection;


/**
 * A user runs the application, click on *delete a user*, select a user in the listview,
 * click on the delete button and finally confirm his action.
 * The class *StoryLineSelectAUserAndConfirmMock* explicitly defines what we expect about an instance
 * of the type UserService in this storyline.
 */

public class StorylineSelectAUserAndConfirmMock extends Storyline {
    public StorylineSelectAUserAndConfirmMock(UserService userService) {
        super(userService);
    }

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

        EasyMock.expect(yohan.getId()).andReturn(1L);
        EasyMock.expect(fred.getLastName()).andReturn("MOAL").anyTimes();
        EasyMock.expect(fred.getFirstName()).andReturn("Fred").anyTimes();

        /**
         * Explicitly, we define that we expect a call of the method deleteUser with the parameter 1L
         */


        getUserService().deleteUser(1L);

        /**
         * We construct a new collection in which the mock carrying the identifier 1L is not present.
         * This call is the one expected as soon as the change has been requested on the user service.
         */

        Collection<User> personnes1 = new ArrayList<>();
        EasyMock.expect(getUserService().getUsers()).andReturn(personnes1);

        personnes1.add(fred);

        EasyMock.expect(fred.getId()).andReturn(1L).anyTimes();

        /**
         * The mocks have to be set as ready for this storyline
         */
        EasyMock.replay(yohan,fred, getUserService());


    }
}
