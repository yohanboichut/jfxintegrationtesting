package storylines;

import model.UserService;

public abstract class Storyline {

    private UserService userService;

    public Storyline(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public abstract void execute();
}
