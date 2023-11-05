FROM jelastic/maven:3.9.5-correttojdk-17.0.9.8.1 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM jelastic/maven:3.9.5-correttojdk-17.0.9.8.1
WORKDIR /usr/src/app

RUN mkdir -p /usr/src/app/.m2 && mkdir /usr/src/app/.m2/repository
COPY --from=build /usr/src/app/target/rss-tracker-service-1.0.0-SNAPSHOT.jar .


EXPOSE 8080
ENTRYPOINT ["java","-jar","rss-tracker-service-1.0.0-SNAPSHOT.jar"]