# Menggunakan image Java 11 sebagai base image
FROM maven:3.8.5-openjdk-17

WORKDIR /app
# Menyalin file JAR aplikasi Spring Boot ke dalam container
COPY . .


CMD mvn spring-boot:run
