# FamilyDoctor
Family Doctor backend



# Swagger 
zrodla:https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
zrodla:https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/

1)Konfiguracja Swagger w osobnej paczce ponieważ trzymam się pojedynczej odpowiedzialnosci --> Single Responsibility.
Config SwaggerConfig z klasą jawową SwaggerConfig, nalezy wpisać kongurację np @Configuration...(4.1 ze strony  
https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api) uzupełnione o rozszerzenia extends ( ze 
strony https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/ - pkt.Configurating Swagger 2 in Application,
lecz nie cały).
2)oraz uzupełnić pom o dependency  (jeden obsługuje UI - interfejs, drugi udostępnia całe api systemu i wystwietla jsonem )   
```xml

                       <dependency>
                              <groupId>io.springfox</groupId>
                              <artifactId>springfox-swagger2</artifactId>
                              <version>2.9.2</version>
                          </dependency>
                          <dependency>
                              <groupId>io.springfox</groupId>
                              <artifactId>springfox-swagger-ui</artifactId>
                              <version>2.9.2</version>
                          </dependency> 
``` 
postepy mojej dotychczasowej pracy widac na stronie:                                         
http://localhost:8080/swagger-ui.html#/patient-resource
