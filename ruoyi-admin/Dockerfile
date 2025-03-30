# 使用多阶段构建优化镜像大小
FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
# COPY src ./src/
RUN mvn package -DskipTests

# 运行时镜像
FROM openjdk:17-jdk-slim
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 6039
ENTRYPOINT ["java", "-jar", "app.jar"]


