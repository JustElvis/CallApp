# CallApp
___
## :bulb: ***Project description***

    Web-application that alows collect and store customers data.

## :scroll: ***Project structure***

    The project has an N-Tier Architecture.

+ *Dao*
+ *Service*
+ *Controller*

## :exclamation: ***Features***

+ *Receive get and post requests*
+ *Save data to database*
+ *check valid phone numbers (length, format) and email addresses*
+ *Throw custom errors messages to the client*
+ *Search customers by phone number and by email*

## :books: ***Technologies***

+ *MySql*
+ *Maven*
+ *Stream API*
+ *Hibernate*
+ *Spring WEB*
+ *Spring Boot*
+ *Spring Boot Jpa*
+ *Lombok*
+ *REST*
+ *SOLID principles*
+ *Swagger*

## :desktop_computer: ***Quickstart***

1. Fork this repository
2. Copy link of project
3. Create new project from Version Control
4. Set the necessary parameters in resources/application.properties
```java
    spring.datasource.driverClassName=YOUR_DRIVER
    spring.datasource.url=YOUR_DATABASE_URL
    spring.datasource.username=YOUR_LOGIN
    spring.datasource.password=YOUR_PASSWORD
```

5. Run project
6. Test all controllers by swagger. Follow next link :

http://localhost:8080/swagger-ui/#/
