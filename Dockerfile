FROM maven:3.8.1-jdk-11 AS MAVEN_TOOL_CHAIN
ARG PROFILE
COPY /pom.xml /tmp/
COPY /src /tmp/src/
WORKDIR /tmp/
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
