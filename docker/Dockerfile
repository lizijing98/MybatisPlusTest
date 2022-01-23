FROM openjdk:8
MAINTAINER Lizijing <lizijing98@live.com>
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
ADD MybatisPlusTest-0.0.1-SNAPSHOT.jar /app.jar
RUN apt-get update
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=test"]
EXPOSE 9090