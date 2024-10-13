
# Final Stage - Create Image for running the application
FROM openjdk:22

# Copy the jar file built in the first stage
COPY ./target/appointment-service.jar ./appointment-service.jar

# Command to run the application
CMD ["java", "-jar", "/appointment-service.jar"]