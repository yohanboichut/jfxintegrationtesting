package model;

import java.util.Collection;

public interface UserService {

    /**
     *
     * @return the collection of all the registered users
     */

    Collection<User> getUsers();


    /**
     * Delete of the datas the user whose the identifier is *id*
     * @param id
     */
    void deleteUser(long id);

    /**
     * Add a new user in the datas. A new identifier is generated and the data carried in *u*
     * are copied.
     * @param u
     * @return
     */
    long addUser(User u);
}
