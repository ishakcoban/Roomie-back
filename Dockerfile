FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your host into the container
COPY target/roomie-0.0.1-SNAPSHOT.jar roomie-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application will run on (default is 8080)
EXPOSE 8080

# Run your application when the container starts
CMD ["java", "-jar", "roomie-0.0.1-SNAPSHOT.jar"]
