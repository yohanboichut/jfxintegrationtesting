# jfxintegrationtesting
This project illustrates a way to perform integration testing on GUI applications
The service layer is mocked using Easymock but we use mocks in order to define what the application is supposed to do. 
Our test suite is organized in such a way that our futur service implementation will inherit of the planned test defined intially with mocks.

