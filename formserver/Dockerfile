# Build this docker container from the root of the monorepo (see readme)
FROM openjdk:11 as builder
RUN \
    apt-get update -yq \
    && apt-get install curl gnupg -yq \
    && curl -sL https://deb.nodesource.com/setup_8.x | bash \
    && apt-get install nodejs -yq
COPY . /usr/src/formfiller
WORKDIR /usr/src/formfiller
RUN ./gradlew :formserver:assemble


FROM openjdk:11
RUN \
    apt-get update && \
    apt-get -y install curl build-essential unzip
RUN \
    mkdir -p /tmpbuild/libsodium && \
    cd /tmpbuild/libsodium && \
    curl -L https://download.libsodium.org/libsodium/releases/libsodium-1.0.17.tar.gz -o libsodium-1.0.17.tar.gz && \
    tar xfvz libsodium-1.0.17.tar.gz && \
    cd /tmpbuild/libsodium/libsodium-1.0.17/ && \
    ./configure && \
    make && make check && \
    make install && \
    mv src/libsodium /usr/local/ && \
    rm -Rf /tmpbuild/
COPY --from=builder /usr/src/formfiller/formserver/build/libs/formServer.jar .

ENTRYPOINT ["java", "-jar", "formServer.jar"]