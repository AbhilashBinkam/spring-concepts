spring-actuator-features.

1. Create the application with spring-boot-starter-actuator dependency and run the application.
2. hit "http://localhost:8080/actuator" 

The above results in displaying the 4 endpoints related to monitoring status of the application. To display all the provided endpoints we need to add the below property in the application-*.properties

1. management.endpoints.web.exposure.include=*
2. restart the application


--------------------------------------------------------------------------


http://localhost:8080/actuator/info --> To display static data we've to follow the below process

when we run the application the above URL doesn't display any data. we can configure the properties and add release notes/ any details related to the application using the property 'info'

info.{we can add any attribute}
info.application.name=spring-actuator-features
info.application.description=spring actuator enhancements 2.0
info.application.artifact=spring-actuator-features
info.application.version=0.0.1

AND

info.tech-stack.spring-boot=2.4.3
info.tech-stack.java=1.8
info.tech-stack.maven=3.6.3
info.tech-stack.DB=MySQL

--------------------------------------------------------------------------

http://localhost:8080/actuator/info --> To display the statistics depending on the dynamic data (i.e data in DB)

Let's say we need to display the users based on active/inactive status. since the user POJO holds status attribute we can achieve it.

1. Write a method in UserRepository to get the count of users based on the user status.
2. Create a new class and implement InfoContributor interface by overriding contribute method. 
3. get the details of the active/inactive users and insert the key value pairs to a map
4. builder.withDetail("<provide key to be displayed>","<map details>");


--------------------------------------------------------------------------

Apart from spring provided monitoring endpoints we can add custom endpoints to the existing actuators list

1. crate a class and annotate (@Endpoint) 
2. For read operation we can annotate the method with (@ReadOperation)

--------------------------------------------------------------------------

we can filter the content with the custom endpoint. 

1. Add @Selector annotation the the method arguments


--------------------------------------------------------------------------

@WriteOperation is used to write the new version details dynamically.

1. 
