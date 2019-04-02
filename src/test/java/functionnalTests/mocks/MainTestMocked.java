package functionnalTests.mocks;

import storylines.mocks.StorylineFactoryMocks;
import functionnalTests.MainTest;

public class MainTestMocked extends MainTest {


    public MainTestMocked() {
        super(new ServiceFactoryMock(), new StorylineFactoryMocks());



    }

}
