FROM clojure:openjdk-11-lein as build-env

ADD . /app
WORKDIR /app

RUN lein uberjar

# -----------------------------------------------------------------------------

FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S tour && \
    adduser -s /bin/false -G tour -S tour

RUN mkdir /app
COPY --from=build-env /app/target/uberjar/tourofclojure-*-standalone.jar /app/tour-clj.jar
COPY dev/resources/config.yml /app/config.yml
ENV CONFIG_PATH=/app/config.yml

USER tour

ENTRYPOINT ["java", "-ea", "-XX:+AlwaysPreTouch", "-XX:MaxRAMPercentage=90", "-cp", "/app/tour-clj.jar"]

CMD ["tourofclojure.core"]
