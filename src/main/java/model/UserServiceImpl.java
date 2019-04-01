package model;

import java.util.ArrayList;
import java.util.Collection;

public class UserServiceImpl implements UserService {

    Collection<User> users;

    int ids;

    public UserServiceImpl() {
        users = new ArrayList<>();
        this.ids =0;
    }

    @Override
    public Collection<User> getUsers() {
        return users;
    }

    @Override
    public void deleteUser(long id) {
        User selectedOne = null;
        for (User u : users) {
            if (u.getId() == id) {
                selectedOne = u;
            }

        }
        users.remove(selectedOne);
    }

    @Override
    public long addUser(User u) {
        User user = new UserImpl(ids++,u);

        this.users.add(user);

        return ids;
    }
}
