# FamilyDoctor
Family Doctor backend



# Swagger 

1. Konfiguracja Swagger w osobnej paczce, ponieważ trzymam się pojedynczej odpowiedzialności --> Single Responsibility.
    1. Config SwaggerConfig z klasą Java SwaggerConfig, należy wpisać konfigurację za pomocą adnotacji @Configuration – szczegóły w pkt. 4.1 ze strony  
https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api.  
    1. Jako, że używam Spring Boot 2 konfiguracja musi rozszerzać klasę WebMvcConfigurationSupport – wskazówka na stronie https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/ w pkt. Configurating Swagger 2 in Application
2. Uzupełnić pom o dependency  (jeden udostępnia całe API systemu, drugi obsługuje UI – interfejs graficzny)   
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

Postępy mojej dotychczasowej pracy widać na stronie:                                         
http://localhost:8080/swagger-ui.html#/patient-resource
 
## Źródła
* https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
* https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/



## QuickStart to Create Spring Project:
IntelliJ
Project -> Spring Initilazer -> Next ->
*Group (com.github.magdauk) - the same like Package
*Artifact (FamilyDoctor)-> Next 
Core: Lombock
Web: Web
SQL: Postgresql
-> Next 

## Others
gitIgnore -> ignore file to push in branch
pom -> libarry, dependency, plugin
source -> main (implementation)

