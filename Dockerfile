FROM maven
WORKDIR /app
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/todo
COPY --from=0 /app/target/ToDo-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
