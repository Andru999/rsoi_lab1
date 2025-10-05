# Этап сборки
FROM gradle:8.5-jdk11 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем только файлы конфигурации Gradle (для кэширования зависимостей)
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY gradle gradle

# Даем права на выполнение gradlew
RUN chmod +x gradlew

# Копируем исходный код
COPY src src

# Собираем приложение (пропускаем тесты для ускорения сборки)
RUN ./gradlew build -x test --no-daemon

# Финальный этап
FROM eclipse-temurin:17-jre-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Создаем пользователя для безопасности (не root)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Копируем собранный JAR из этапа сборки
COPY --from=build /app/build/libs/*.jar app.jar

# Открываем порт (Render использует переменную PORT)
EXPOSE 8080

# Параметры для оптимизации JVM в контейнере
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:MaxRAMPercentage=75"

# Запуск приложения
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dserver.port=${PORT:-8080} -jar /app/app.jar"]