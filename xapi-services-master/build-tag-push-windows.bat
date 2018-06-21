@echo off
set service_name=%1
shift

echo service_name: %service_name%

:::::: BUILD :::::::::::

:: build source code to .jar file
call mvn clean package -Dmaven.test.skip=true

:: build docker image and tag
:: "." is the folder where we call this script
echo docker build
docker build -t 172.30.1.1:5000/myproject/%service_name% .

:: push the image to the openshift docker registry
echo docker push
docker push 172.30.1.1:5000/myproject/%service_name%

:: verify that the image was uploaded
echo oc get istag
oc get istag


