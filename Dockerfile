# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

RUN chmod +x /app/entrypoint.sh

# Expose the port that your application will run on
EXPOSE 8080

# Define the command to run your application
CMD ["/app/entrypoint.sh"]
