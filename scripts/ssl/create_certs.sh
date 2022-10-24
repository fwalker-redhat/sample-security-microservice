#!/bin/bash
CUR_DIR=`pwd`
echo $CUR_DIR
cd "${0%/*}"
if [ ! -d "../../src/main/resources/META-INF/resources/" ]
then
    mkdir -p ../../src/main/resources/META-INF/resources/
fi
keytool -genkeypair -storepass password -keyalg RSA -keysize 2048 -dname "CN=sample-service-1" -alias sample-service-1 -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore ../../src/main/resources/META-INF/resources/service-1.keystore
keytool -genkeypair -storepass password -keyalg RSA -keysize 2048 -dname "CN=sample-service-2" -alias sample-service-2 -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore ../../src/main/resources/META-INF/resources/service-2.keystore
cd $CUR_DIR