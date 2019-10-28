
With the backend application (@Controller) you need to create a WAR file (<packaging>war</packaging> in the POM) via the command:

$ mvn clean package


You should establish that the WAR file produces the correct behaviour by deploying it to the local tomcat service on linux.
This can be done using the Tomcat Web Application Manager

This can be done by using the command:

systemctl status tomcat8.service (to check if the service is running)
systemctl start tomcat8.service  (to start the service)

The correct behaviour in this instance being successful deployment to tomcat.

To check if the application has been deployed, click the 'msFrontEnd' link in Tomcat Web Application Manager

This will open a browser and take you to :

http://localhost:8080/msFrontEnd/

You should see the home page of the application along with a submit button.

Once the WAR file has been deployed it is not necessary to re-deploy unless the application has been modified.

As long as the tomcat service is kept running the application should be accessible.





When deploying to AWS bear in mind the following:

Platform: Tomcat 8.5 with Java 8 running on 64bit Amazon Linux/3.3.0
Environment Properties (Configuration)
SERVER_PORT does not need to be set as the application runs on an internal tomcat server on it's default port 8080

http://www.swanseabay-results.co.uk

