# Install Tomcat & openjdk 8 (has java and javac)
FROM tomcat:jdk8-openjdk

RUN apt update -y

RUN apt install -y libmariadb-java

RUN mkdir -p /usr/local/tomcat/webapps/app/WEB-INF/classes/

RUN cp /usr/share/java/mariadb-java-client.jar /usr/local/tomcat/lib/

# Copy source files to tomcat folder structure
COPY . /usr/local/tomcat/webapps/


RUN javac -cp ".:/usr/local/tomcat/lib/servlet-api.jar:/usr/share/java/mariadb-java-client.jar" -d "/usr/local/tomcat/webapps/app/WEB-INF/classes/" "/usr/local/tomcat/webapps/app/src/Demo.java"

# Serve Tomcat
EXPOSE 8080

CMD ["catalina.sh", "run"]
