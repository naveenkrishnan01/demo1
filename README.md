### Project Description

### Library Reference
```sh
Java-8
Maven - Build Tool # Gradle is another option
Swagger - Open API - 3.0.0 version
Spring Dependencies - check pom.xml
```
###  pom library for swagger
```sh
	   <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>3.0.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>3.0.0</version>
        </dependency>
        <dependency>
```
### application-properties file
```sh
swagger3.enable=true
swagger3.title=Spring Demo Application
swagger3.description= All the Api in this Project
```

### Configuration
```sh
 @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // Whether to enable
                .enable(enableSwagger)
                // swagger ui header information
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .build();
    }
```

### Run the application
```sh
   mvn spring-boot:run
```
### Test the application
```sh
   mvn test
```

