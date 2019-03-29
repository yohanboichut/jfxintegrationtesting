package storylines;

import model.UserService;

public interface StorylineFactory {
    Storyline getScenario(UserService userService, String cle);
}
