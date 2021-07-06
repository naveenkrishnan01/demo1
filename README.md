### Project Description

### Library Reference
```sh
Java-8
Maven - Build Tool # Gradle is another option
Spring Dependencies - check pom.xml
```

### Code Component
```sh
Persistent Layer
  - JPA(CrudRepository)
  - DataBase - Mysql

Service Layer
  - Crud Operations and any additional logic can be added thru services

Data Transfer Object(DTO) - Table Entity
  - Java Object to transfer the data into the database
  
Controller - Api methods
  - Api action for crud operations for presenting the input and 
     output operation in json format(default format)
     
Configuration
   - DB connection for local machine
   - Raw sql for initial setup
        
Unit test - Junit5/Mockito
  - Test for Jpa and Services

```
### Following api can be tested
```sh
   http://localhost:8080/test  - GET (gives all records in DB)
   http://localhost:8080/test/1 - GET (Will give one record back based on id)
   http://localhost:8080/name/way - GET (Will give all the records that matches the search)
   http://localhost:8080/test - POST (Add record by passing input in json format)
```

### Run the application
```sh
   mvn spring-boot:run
```

