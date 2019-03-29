package model;

import java.util.Collection;

public interface UserService {


    Collection<User> getUsers();

    void deleteUser(long id);

    long addUser(User u);
}
