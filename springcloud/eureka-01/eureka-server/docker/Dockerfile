FROM openjdk:8
ENV workdir=/root/eureka-server-test/eureka-server
COPY . ${workdir}
EXPOSE 8761
CMD ["java", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]