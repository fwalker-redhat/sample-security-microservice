#!/bin/bash
CUR_DIR=`pwd`
echo $CUR_DIR
cd "${0%/*}"
if [ ! -d "../../src/main/resources/META-INF/resources/" ]
then
    mkdir -p ../../src/main/resources/META-INF/resources/
fi
keytool -genkeypair -storepass password -keyalg RSA -keysize 2048 -dname "CN=sample-service-server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore ../../src/main/resources/META-INF/resources/server.keystore
keytool -genkeypair -storepass password -keyalg RSA -keysize 2048 -dname "CN=sample-service-client" -alias client -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore ../../src/main/resources/META-INF/resources/client.keystore
cd $CUR_DIR