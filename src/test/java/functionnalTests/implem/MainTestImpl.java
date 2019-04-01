package functionnalTests.implem;

import model.ServiceFactoryImpl;
import storylines.impl.StorylineFactoryImpl;
import storylines.mocks.StorylineFactoryMocked;
import functionnalTests.MainTest;

public class MainTestImpl extends MainTest {


    public MainTestImpl() {
        super(new ServiceFactoryImpl(), new StorylineFactoryImpl());



    }

}
