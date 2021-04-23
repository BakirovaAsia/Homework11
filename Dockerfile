FROM tomcat:latest

RUN cp -r ./target/CaucusCalculator* /usr/local/tomcat/webapps/