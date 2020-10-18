## Project purpose
Implement an online store with basic functionality, fundamentally use JDBC technology to show how modern ORM frameworks work.

Project uses N-tier architecture with DB layer, DAO layer, Service layer, Controllers layer and View layer.
This project has been developed according to SOLID principles with authorization and authentication(hashing and salt used) by RBAC filter strategy.

## Project structure
**REGISTRATION**: standard *registration* procedure for a new user  
**LOGIN**: if you have already registered, you can *logging* on this page   

**INJECT -> INJECT PRODUCTS**: after registration and logging in as the new user, push "Inject Products" button to insert products at Data Base.  
**USER MENU -> PRODUCT**: after Injecting products to the DB you can choose what product do you want to buy and push the button "ADD to CART"      
**USER MENU -> CART**: in your shopping cart you can remove an unwanted product and click the button checkout   
**USER MENU -> ORDER**: in your orders you can remove an unwanted order or looking for the details  

**INJECT -> INJECT ADMIN**: push "Inject admin" button After this procedure you may login as Admin using "admin" as login and "admin" as password   
**USER ADMIN -> VIEW USERS**: you can see all registered users at this moment  
**USER ADMIN -> VIEW ORDERS**: you can see all orders of all users  
**USER ADMIN -> MANAGE PRODUCTS**: you can remove an unwanted product from DB  
**USER ADMIN -> MANAGE PRODUCTS**: you can create some product and add to DB  

## Technologies used
**backend**: Java, Servlets, Tomcat, JDBC  
**frontend**: HTML, CSS, Bootstrap, JSP, JSTL  
**database**: MySQL  

## Launch guide
1) *Download and install* the [JDK](https://www.oracle.com/java/technologies/javase-downloads.html, "Download JDK") <br>
2) *Download and install* servlet container (for example Apache [Tomcat](https://tomcat.apache.org/download-90.cgi, "Download Tomcat"))<br>
3) *Download and install* [MySQL Server](https://dev.mysql.com/downloads/)<br>
+ Setup new connection with<br>
  + user: *"your username"*<br>
  + password: *"your password"*<br>
  + url: jdbc:mysql://*"your host name"*:*"your port"*/*"your name db"*?useUnicode=true&serverTimezone=UTC<br>
+ Create schema internet_shop<br>
+ Create tables using commands from init_db.sql under the path src/main/resources/<br>

## Dependencies
+ [MySQL](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.21)
+ [JSTL](https://mvnrepository.com/artifact/jstl/jstl/1.2)
+ [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.12)
+ [Servlet](https://mvnrepository.com/artifact/javax.servlet/servlet-api/2.5)


## Author
 [Artem Vremere](https://github.com/vremere-a "Author")