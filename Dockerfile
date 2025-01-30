# Используйте официальный образ Java
FROM eclipse-temurin:17-jdk-jammy

# Рабочая директория внутри контейнера
WORKDIR /app

# Скопируйте JAR-файл в контейнер
COPY target/server-1.0-SNAPSHOT.jar /app/app.jar

# Откройте порт, который использует приложение
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]