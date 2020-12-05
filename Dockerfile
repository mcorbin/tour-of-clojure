FROM clojure:openjdk-11-lein as build-env

ADD . /app
WORKDIR /app

RUN lein uberjar

# -----------------------------------------------------------------------------

from openjdk:11

RUN groupadd -r tour-clj && useradd -r -s /bin/false -g tour-clj tour-clj
RUN mkdir /app
COPY --from=build-env /app/target/uberjar/tour-clj-*-standalone.jar /app/tour-clj.jar

RUN chown -R tour-clj:tour-clj /app

RUN apt-get update && apt-get -y upgrade && apt-get install -y git
user tour-clj

ENTRYPOINT ["java"]

CMD ["-jar", "/app/tour-clj.jar"]
