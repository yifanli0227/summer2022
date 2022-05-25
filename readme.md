Setup:
    1.MySQL setting is in application.propeties.
    2.Use init.sql file to initialize a database.
    3.Uncomment the last chunk of DemoApplication.java to add three user into databse.
    4.After first run of application, comment out the portion from step 3. 

Usage:
    Login:
        Go to localhost:8080 to test login. Credentials can be found in DemoApplication.java
        After successful login, you should see a message with json object
        Then go to localhost:8080/index to test user access level

To do:
    Change login method to ajax for better frontend backend seperation.
    Create REST API for frontend. 