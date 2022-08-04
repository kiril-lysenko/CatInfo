# CatInfo
For starting application prefer docker-compose, but you also can use maven
### Maven Instruction
Change liquibase flag and change database configs for your own in application.properties as below 
````
spring.liquibase.enabled=true
````
````
mvn clean install
````
````
 mvn --projects backend spring-boot:run
````
### Docker Instruction
Build and Run Docker Images
````
docker-compose up
````
Rebuild Docker Images
````
docker-compose build
````
Local:
   + http://localhost:8080/
   + http://localhost:8080/swagger-ui/index.html

Idea for project took from testing task WG Forge(Backend): https://github.com/wgnet/wg_forge_backend