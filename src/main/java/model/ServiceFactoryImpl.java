package model;

public class ServiceFactoryImpl implements ServiceFactory {
    @Override
    public UserService getFacade() {
        return new UserServiceImpl();
    }
}
