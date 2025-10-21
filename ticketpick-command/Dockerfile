# Build stage
FROM gradle:8.5-jdk21 AS build
WORKDIR /app

# 전체 프로젝트 복사 (멀티 모듈)
COPY . .

# Command 모듈만 빌드
RUN gradle :ticketpick-command:bootJar -x test

# Runtime stage
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/ticketpick-command/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
