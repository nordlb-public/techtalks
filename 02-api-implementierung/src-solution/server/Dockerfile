# ---
# Building Stage
FROM maven:3.6.2-jdk-13 AS build

# make source folder
RUN mkdir -p /usr/src/app

# set working directory
WORKDIR /usr/src/app

# copy pom
COPY pom.xml /usr/src/app

# install dependencies
RUN mvn dependency:go-offline

# copy other source files (keep in image)
COPY src /usr/src/app/src

# compile package
RUN mvn package

# ---
# Running Stage
FROM openjdk:13

# copy jar file from building stage
COPY --from=build /usr/src/app/target/openapi-spring-1.0.0.jar /usr/app/app.jar

# run jar file
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]