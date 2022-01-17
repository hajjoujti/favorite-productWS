FROM openjdk:11
VOLUME [ "/tmp" ]
ADD productWS.jar productWS/
EXPOSE 9092
ENTRYPOINT [ "sh","-c","java -jar /productWS.jar" ]