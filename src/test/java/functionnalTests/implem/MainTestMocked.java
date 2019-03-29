package functionnalTests.implem;

import storylines.mocks.StorylineFactoryMocked;
import functionnalTests.MainTest;

public class MainTestMocked extends MainTest {


    public MainTestMocked() {
        super(new ServiceFactoryImpl(), new StorylineFactoryMocked());



    }

}
