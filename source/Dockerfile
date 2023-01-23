# Dockerfile
FROM adoptopenjdk:openjdk11
MAINTAINER WEB_EXAMPLE

# Passed by caller
ARG JAR_VERSION

RUN mkdir -p /opt/web_example

# Copy ac-services jar
ENV WEB_EXAMPLE_JAR=SpringWebApplication-${JAR_VERSION}.jar
COPY "ac-services/target/$WEB_EXAMPLE_JAR" /opt/web_example

WORKDIR /opt/web_example

# Services app entrypoint
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar $WEB_EXAMPLE_JAR" ]
