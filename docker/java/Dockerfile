FROM java:8

EXPOSE 8080

ENV JAR_FILE="dream-api.jar"

COPY ./${JAR_FILE}  ${JAR_FILE}

ENTRYPOINT [ "sh", "-c", "java -jar ${JAR_FILE} --spring.profiles.active=docker" ]