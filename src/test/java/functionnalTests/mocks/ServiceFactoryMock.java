package functionnalTests.mocks;

import model.ServiceFactory;
import model.UserService;
import org.easymock.EasyMock;

public class ServiceFactoryMock implements ServiceFactory {


    @Override
    public UserService getFacade() {
        return EasyMock.createMock(UserService.class);
    }
}
