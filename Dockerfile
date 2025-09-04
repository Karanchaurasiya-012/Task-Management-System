FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# mvnw ko executable banao
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/trial-0.0.1-SNAPSHOT.jar"]
