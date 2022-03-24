FROM openjdk:11
#FROM openjdk:11-jre-slim
#FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/insta-post-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} inst-post.jar
ENTRYPOINT ["java","-jar","/inst-post.jar"]