FROM maven:3.5-jdk-8
COPY . .
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "./target/web-producer-0.0.1-SNAPSHOT.jar"]