# Etapa de construção
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM tomcat:9.0-jdk17-corretto
WORKDIR /usr/local/tomcat/webapps/
COPY --from=build /app/target/TropicaliasFinal-1.0-SNAPSHOT.war ./ROOT.war
EXPOSE 8080
