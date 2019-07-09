FROM java:8
EXPOSE 8081

VOLUME /tmp
ADD geoin-iot.jar  /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
