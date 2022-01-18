FROM openjdk:11
VOLUME ["/tmp"]
ADD productWS.jar app.jar
EXPOSE 9092
ENTRYPOINT [ "sh","-c","java -jar /app.jar" ]
