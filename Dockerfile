FROM openjdk:11-jre-slim
EXPOSE 8080
ADD target/*.jar /employee-app.jar
ENTRYPOINT java $JAVA_OPTS -jar /employee-app.jar