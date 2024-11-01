# Etapa de construção: criar o arquivo .war
FROM maven:latest AS warfile
WORKDIR /tropicalias
COPY pom.xml . 
RUN mvn -B -f pom.xml dependency:resolve
COPY . .
RUN mvn -B package -DskipTests

# Etapa de execução: Tomcat para rodar o .war
FROM tomcat:9.0-jre8-alpine
# Definindo o diretório de trabalho no Tomcat
WORKDIR /usr/local/tomcat/webapps
COPY run.sh run.sh
RUN chmod +x run.sh
# Copiar o arquivo .war gerado na etapa de construção para o diretório de aplicativos do Tomcat com um nome único
COPY --from=warfile /usr/src/tropicalias/target/TropicaliasFinal-1.0-SNAPSHOT.war TropicaliasApp.war

# Expondo a porta para o Tomcat
EXPOSE 8080

# Inicializando o Tomcat
CMD ["catalina.sh", "run"]

# -------------------------------------------------------------------------------------------------

#MAINTAINER Sophia Parafina <sophia.parafina@docker.com>

# build servlet and create war file
FROM maven:latest AS warfile
WORKDIR /usr/src/tropicalias
COPY pom.xml .
RUN mvn -B -f pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY . .
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package

FROM tomcat:9.0-jre8-alpine
# ADD tomcat/catalina.sh $CATALINA_HOME/bin/
WORKDIR /usr/local/tomcat/bin
COPY run.sh run.sh
RUN chmod +x run.sh
#Copy war file
WORKDIR /usr/local/tomcat/webapps
COPY  --from=warfile /usr/src/tropicalias/target/TropicaliasFinal-1.0-SNAPSHOT.war TropicaliasApp.war
# Expose ports
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"
EXPOSE 8080
WORKDIR /usr/local/tomcat/bin
CMD ["run.sh"]
