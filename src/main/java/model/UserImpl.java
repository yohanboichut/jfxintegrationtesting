package model;

public class UserImpl extends User {
    public UserImpl(long id, User u) {
        super(id, u);
    }

    public UserImpl(String lastName, String firstName) {
        super(lastName, firstName);
    }
}
