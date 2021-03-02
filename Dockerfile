FROM openkbs/jdk11-mvn-py3
MAINTAINER shoyos "sebastian.hoyos@ceiba.com.co"
COPY ./build/libs/* .
EXPOSE 80
EXPOSE 8080
ENTRYPOINT ["java","-jar","consignataria2-0.0.1-SNAPSHOT.jar"]