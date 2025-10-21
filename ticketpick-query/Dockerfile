# Build stage
FROM gradle:8.5-jdk21 AS build
WORKDIR /app

# 전체 프로젝트 복사
COPY . .

# Query 모듈만 빌드
RUN gradle :ticketpick-query:bootJar -x test

# Runtime stage
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/ticketpick-query/build/libs/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
