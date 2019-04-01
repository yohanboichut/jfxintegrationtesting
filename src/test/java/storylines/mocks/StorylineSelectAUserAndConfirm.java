package storylines.mocks;

import model.UserService;
import model.User;
import org.easymock.EasyMock;
import storylines.Storyline;

import java.util.ArrayList;
import java.util.Collection;

public class StorylineSelectAUserAndConfirm extends Storyline {
    public StorylineSelectAUserAndConfirm(UserService userService) {
        super(userService);
    }

    @Override
    public void execute() {
        Collection<User> users = new ArrayList<>();
        User yohan = EasyMock.createMock(User.class);
        User fred = EasyMock.createMock(User.class);
        users.add(yohan);
        users.add(fred);
        EasyMock.expect(getUserService().getUsers()).andReturn(users);

        EasyMock.expect(yohan.getLastName()).andReturn("BOICHUT").anyTimes();

        EasyMock.expect(yohan.getFirstName()).andReturn("Yohan").anyTimes();

        EasyMock.expect(yohan.getId()).andReturn(1L);
        EasyMock.expect(fred.getLastName()).andReturn("MOAL").anyTimes();

        EasyMock.expect(fred.getFirstName()).andReturn("Fred").anyTimes();


        getUserService().deleteUser(1L);


        Collection<User> personnes1 = new ArrayList<>();
        EasyMock.expect(getUserService().getUsers()).andReturn(personnes1);

        personnes1.add(fred);

        EasyMock.expect(yohan.getId()).andReturn(0L).anyTimes();


        EasyMock.expect(fred.getId()).andReturn(1L).anyTimes();


        EasyMock.replay(yohan,fred, getUserService());


    }
}
