## Installation

    1.MySQL setting is in application.propeties.
    2.Use init.sql file to initialize a database.
    3.Uncomment the last chunk of DemoApplication.java to add three user into databse.
    4.After first run of application, comment out the portion from step 3. 

## Usage
    Login:
        Send a POST request with {"username":"youusername","password":"yourpwd"} to localhost:8080/login
        You should receive a Json object with status code and your authorities.
    Role Based Access Control(RBAC):
        demo1 is assigned ADMIN and USER roles, it can access with GET request localhost:8080/admin and /user
        accessing /reader, which it does not have access to with result a 403 code in json
        

## Todo
    Implements JWT.
    User registration.
