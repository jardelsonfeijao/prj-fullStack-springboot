# Stage 1: build do jar
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app
# só copiar o pom para aproveitar cache
COPY pom.xml .
# baixar dependências sem compilar código
RUN mvn dependency:go-offline -B

# copiar código-fonte e empacotar
COPY src ./src
RUN mvn clean package

# Stage 2: runtime leve
FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /app
# copia apenas o jar final
COPY --from=builder /app/target/*.jar app.jar

# expõe porta padrão do Spring Boot
EXPOSE 8080

# configurações de JVM
ENV JAVA_OPTS="-Xms256m -Xmx512m"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
