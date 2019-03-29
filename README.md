# Test of a JFx Application by Mocking the Service Layer
This project illustrates a way to perform **integration testing** on **GUI applications**.
The service layer is mocked using **Easymock**. Thus, we define **use-cases** in **TestFx** by mocking the service layer. 
Our **test suite** is organized in such a way that our **future service implementation** will 
inherit of the planned test defined intially with mocks.




## The Service layer (*model package*)
Our service is a very simple service whose goal is to handle a set of users. It is composed of one interface **UserService** 
and an abstract class **User**. We add also a factory **ServiceFactory**. A user has a last name and a first name.

## The JFx views (*views package*)
This application is really minimalist. The menu is composed of two buttons (*Menu*): *Delete a user* and *quit*. 
Clicking on *Delete a user* leads you toward a lovely pane (*UserList*) composed of a listview (*Li#   stView*) and two buttons 
(*delete a user* and *menu*).

## The Controller (*controller package*)
Basically, like in any MVC application, the controller has its orchestral role.

## What are these Storylines?
In the class *MainTest*, one can denote two basic storylines: 
* a user runs the application, click on *delete a user*, 
select a user in the listview, click on the delete button and finally cancel his action.
* a user runs the application, click on *delete a user*, select a user in the listview, click on the delete button and 
finally confirm his action. 
