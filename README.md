### Project Description

### Library Reference
```sh
Java-8
Maven - Build Tool # Gradle is another option
Spring Dependencies - check pom.xml
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
### Run the application
```sh
   mvn spring-boot:run
```
# demo1
