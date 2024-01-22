FROM openjdk:17-jdk-slim
VOLUME /tmp

ADD ./target/user-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar","/user.jar"]