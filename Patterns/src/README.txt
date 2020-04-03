
Having chosen the Singleton method. I’ve created a new Java project based on a Singleton exercise in class, to later apply the necessary changes to access the database.
The main class creates a new instance of the Frame class. The Frame extends class of JFrame to be able to visualize the components on screen, as well as all the variables and characteristics of the screen. The ButtonListener Initiates class takes a unique instance of the SingeltonWritter class. The ButtonListener class still needs adjustments to make queries in the database, which will be done later.
The SingletonWritter class where the Singleton Pattern is applied has variable locations for connection to the database, in addition to the methods of the single instance, on which this Pattern is based. In addition, ConnectToDatabase and DisconnectDatabase methods have been implemented. The methods of querying records in the database will be implemented later.
https://www.geeksforgeeks.org/singleton-class-java/

Implementation of the DAO method, to achieve the full exercise requirements of the use of 2 patterns.

**Since it was my first time using github on eclipse, I fell that I failed with my a lack of information on my first commits, 
so I've decided to write down some of the project evaluation, that I felt that could have put on my previous commits.**

Evolution of the project

-Upgraded the WinListener class: Connecting and Disconnecting from the database when the events start and close the screen.
-Upgraded the ButtonListener class: adding the methods according to the buttons being selected. Validations on the insertion of the Continent have been added.
-Upgraded the SingletonWritter class: Added the methods of querying records in the database, in addition to the insertion method. In all of these methods try catch was used, in case anything goes wrong in the attempt to connect to the database.

https://www.javatpoint.com/java-actionlistener
https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#fbrica-de-conexes
https://www.codota.com/code/java/methods/java.sql.Statement/executeQuery


-Upgrading the SingletonWritter class to DataSourceSingletonWritter, in order to adapt to receive a new Pattern DAO;
-Addition of the CountryDAO interface;
-Addition of the ToString method in the Country class;

-fixing some spelling errors
-trying to fix the connection with the db, 
-implementing the CountryDAO interface to correctly access the database using the getInstance of the DataSourceSingletonWritter class;
-Update to the ButtonListener class to make the call correctly in the JButton button method ("GET ALL COUNTRIES") 
-MySQLCountryDAO implements the methods listed on the interface CountryDAO, doing a @override of the necessaries methods.




