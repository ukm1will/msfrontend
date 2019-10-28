The frontend

With a backend (@Controller) you need to create a WAR file (<packaging>war</packaging> in the POM)via the command:

$ mvn clean package


You should establish that the WAR file produces the correct behaviour by deploying it to the local tomcat service on linux.
This can be started by the command:

systemctl status tomcat8.service (to check if the service is running)
systemctl start tomcat8.service  (to start the service)

The correct behaviour in this instance being successful deployment to tomcat.


http://localhost:8080/msFrontEnd/
to start the Spring Boot application on port 8080.

To check the correct behaviour, open a browser and go to 'http://localhost:8080/msFrontEnd/'
or, by clicking the 'msFrontEnd' link in Tomcat Web Application Manager


You should see the home page of the application along with a submit button.


When deploying to AWS bear in mind the following:

Platform: Tomcat 8.5 with Java 8 running on 64bit Amazon Linux/3.3.0
Environment Properties (Configuration)
SERVER_PORT does not need to be set as the application runs on an internal tomcat server on it's default port 8080

http://www.swanseabay-results.co.uk

