FROM openjdk:8u181-jdk-alpine

WORKDIR /home/apps/
ADD manage-0.0.1-SNAPSHOT.jar .

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

ENTRYPOINT ["java","-jar","manage-0.0.1-SNAPSHOT.jar"]
