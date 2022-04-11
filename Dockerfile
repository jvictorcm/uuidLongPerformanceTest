FROM openjdk:11

MAINTAINER jvictorcm@gmail.com

COPY build/libs/* app.jar

EXPOSE 30001

ENTRYPOINT ["java","-jar","/app.jar"]