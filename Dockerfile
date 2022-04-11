FROM adoptopenjdk/openjdk11
RUN mkdir /srv/docker-spring
COPY . /srv/docker-spring
WORKDIR /srv/docker-spring
RUN ./gradlew build
RUN mv build/libs/*SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
