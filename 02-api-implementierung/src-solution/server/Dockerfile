FROM maven:3.6.2-jdk-13

ENTRYPOINT ["/usr/bin/mvn"]

# ----
# Install project dependencies and keep sources
# make source folder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# install maven dependency packages (keep in image)
COPY pom.xml /usr/src/app

# copy other source files (keep in image)
COPY src /usr/src/app/src

RUN mvn install
#RUN mvn -T 1C install && rm -rf target

#ENTRYPOINT ["sleep"]
#CMD ["3000000000"]

ENTRYPOINT ["java", "-jar", "/usr/src/app/target/openapi-spring-1.0.0.jar"]