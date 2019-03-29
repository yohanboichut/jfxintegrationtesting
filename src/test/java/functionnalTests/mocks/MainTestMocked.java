package functionnalTests.mocks;

import storylines.mocks.StorylineFactoryMocked;
import functionnalTests.MainTest;

public class MainTestMocked extends MainTest {


    public MainTestMocked() {
        super(new ServiceFactoryMock(), new StorylineFactoryMocked());



    }

}
