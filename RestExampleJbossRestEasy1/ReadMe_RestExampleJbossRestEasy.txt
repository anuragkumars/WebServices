
1. Generate Maven Structure

C:\dev\docs\WebServices\RestExampleJbossRestEasy1>C:\Users\anurag.kumar\Downloads\apache-maven-3.2.1-bin\apache-maven-3.2.1\bin\mvn archetype:generate
 -DgroupId=com.aks.jbossresteasy.webservices -DartifactId=RestExampleJbossRestEasy1_M -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=f
alse
[INFO] Scanning for projects...
[INFO]
[INFO] Using the builder org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder with a thread count of 1
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom >>>
[INFO]
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom <<<
[INFO]
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-webapp:1.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: C:\dev\docs\WebServices\RestExampleJbossRestEasy1
[INFO] Parameter: package, Value: com.aks.jbossresteasy.webservices
[INFO] Parameter: groupId, Value: com.aks.jbossresteasy.webservices
[INFO] Parameter: artifactId, Value: RestExampleJbossRestEasy1_M
[INFO] Parameter: packageName, Value: com.aks.jbossresteasy.webservices
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: C:\dev\docs\WebServices\RestExampleJbossRestEasy1\RestExampleJbossRestEasy1_M
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.076 s
[INFO] Finished at: 2017-07-27T13:09:12-08:00
[INFO] Final Memory: 16M/155M
[INFO] ------------------------------------------------------------------------
C:\dev\docs\WebServices\RestExampleJbossRestEasy1>


2. 

edit pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.aks.webservices</groupId>
  <artifactId>RestExampleJbossRestEasy1_M</artifactId>
  <packaging>war</packaging>
  <version>RestExampleJbossRestEasy1_M_1.0-SNAPSHOT</version>
  <name>RestExampleJbossRestEasy1_M Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.jboss.resteasy</groupId>
        <artifactId>resteasy-jaxrs</artifactId>
        <version>2.3.7.Final</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>
  </dependencies>
  <build>
    <finalName>RestExampleJbossRestEasy1_M</finalName>
  </build>
</project>


3. edit web.xml

<web-app id="WebApp_ID" version="2.4"
    xmlns="http://java.sun.com/xml/ns/j2ee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee 
    http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
     
    <!-- Auto scan REST service -->
    <context-param>
        <param-name>resteasy.scan</param-name>
        <param-value>true</param-value>
    </context-param>
     
    <listener>
        <listener-class>
            org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap
        </listener-class>
    </listener>
     
    <servlet>
        <servlet-name>resteasy-servlet</servlet-name>
        <servlet-class>
            org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher
        </servlet-class>
    </servlet>
   
    <servlet-mapping>
        <servlet-name>resteasy-servlet</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
</web-app>


4. Create java folder / class

C:\dev\docs\WebServices\RestExampleJbossRestEasy1\RestExampleJbossRestEasy1_M\src\main\java\com\aks\webservices\RestExampleJbossRestEasy1.java

package com.aks.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Uses jboss.resteasy
 * 
 * @author anurag.kumar
 *
 */
@Path("/publish")
public class RestExampleJbossRestEasy1 {
 
    @GET
    @Path("/response/{message}")
    public Response publishMessage(@PathParam("message") String msgStr){
         
        String responseStr = "Response for received message: "+msgStr;
        return Response.status(200).entity(responseStr).build();
    }
    
    @GET
    @Path("/query/{message}")
    public Response publishInfo(@PathParam("message") String msgStr){
         
        String responseStr = "Response for received request: "+msgStr;
        return Response.status(200).entity(responseStr).build();
    }
    
}


5. Maven it

C:\dev\docs\WebServices\RestExampleJbossRestEasy1\RestExampleJbossRestEasy1_M>C:\Users\anurag.kumar\Downloads\apache-maven-3.2.1-bin\apache-maven-3.2.
1\bin\mvn -e clean

C:\dev\docs\WebServices\RestExampleJbossRestEasy1\RestExampleJbossRestEasy1_M>C:\Users\anurag.kumar\Downloads\apache-maven-3.2.1-bin\apache-maven-3.2.
1\bin\mvn -e compile

C:\dev\docs\WebServices\RestExampleJbossRestEasy1\RestExampleJbossRestEasy1_M>C:\Users\anurag.kumar\Downloads\apache-maven-3.2.1-bin\apache-maven-3.2.
1\bin\mvn -e package

6. tomcat it

c:\dev\tools\tomcat\apache-tomcat-8.0.23\bin
catalina.bat start

deploy war / copy war

copy C:\dev\docs\WebServices\RestExampleJbossRestEasy1\RestExampleJbossRestEasy1_M\target\RestExample
JbossRestEasy1_M.war .

7. Check web service
http://localhost:8080/RestExampleJbossRestEasy1_M/publish/response/hello


