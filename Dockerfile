FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Fase 2: Execução com Tomcat
FROM tomcat:10.1.19-jdk11
COPY --from=build /app/target/NovoTropicaliasServlet-1.0-SNAPSHOT.jar/ /usr/local/tomcat/webapps/app/
EXPOSE 8080
CMD ["catalina.sh", "run"]
