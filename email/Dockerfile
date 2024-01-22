FROM openjdk:17-jdk-slim
VOLUME /tmp
ADD ./target/email-0.0.1-SNAPSHOT.jar email.jar
ENTRYPOINT ["java","-jar","/email.jar"]