# Etapa de construção: criar o arquivo .war
FROM maven:latest AS warfile
WORKDIR /usr/src/tropicalias
COPY pom.xml . 
RUN mvn -B -f pom.xml dependency:resolve
COPY . .
RUN mvn -B package -DskipTests

# Etapa de execução: Tomcat para rodar o .war
FROM tomcat:9.0-jre8-alpine
# Definindo o diretório de trabalho no Tomcat
WORKDIR /usr/local/tomcat/webapps

# Copiar o arquivo .war gerado na etapa de construção para o diretório de aplicativos do Tomcat com um nome único
COPY --from=warfile /usr/src/tropicalias/target/TropicaliasFinal-1.0-SNAPSHOT.war TropicaliasApp.war

# Expondo a porta para o Tomcat
EXPOSE 8080

# Inicializando o Tomcat
CMD ["catalina.sh", "run"]
