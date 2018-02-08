Login application validates the user against its username/password by comparing it with the registered username/password in the database.


Technology stack
---------------- 

Java EE JDK1.8, JSF2.2 and Oracle DB(OJDBC6).

Server
-------
Tomcat 9.0

Steps to Execute
----------------

> Create a new JSF dynamic web project "LoginExampleWithJSF"
> Install all the jars required(jsf-impl,jsf-api,ojdbc)
> Download tomcat server latest version(9.0)
> Add the project to the server
> Complete the development
> Add the navigation rule in faces config.xml
> Add the welcome file in web.xml
> Project - Clean build the project
> Start the Tomcat Server9.0
> Test the application
> Debug the server if required.


Below are the class files used for Login Project
---------------- ---------------- ---------------- 
(1).Login.java
(2).SessionBean.java
(3).LoginDAO.java
(4).AuthorizationFilter.java
(5).DataConnect.java
(6).Login.xhtml
(7).admin.xhtml

Navigation rules are defined in faces-config.xml

Oracle Database
---------------- 

3 rows are inserted just as an example to the DB whose login credentials can be validated.

Below are the SQL scripts used for DDL and DML
---------------- ---------------- ------------
DDL
---
CREATE TABLE "ASUI_OWNR"."Users" 
   (	"uid" NUMBER, 
	"uname" VARCHAR2(20 BYTE), 
	"password" VARCHAR2(20 BYTE)
   ); 

   
DML
---
 
INSERT INTO "ASUI_OWNR"."Users" VALUES(1,'demotestone','demotestone');
INSERT INTO "ASUI_OWNR"."Users" VALUES(1,'demotesttwo','demotesttwo');
INSERT INTO "ASUI_OWNR"."Users" VALUES(1,'demotestthree','demotestthree');

Jars added
----------
Mojara - jsf-api-2.2.9 , jsf-impl-2.2.9, ojdbc6-11.1.0 and other default jdk jars

IDE used
--------

Eclipse Oxygen