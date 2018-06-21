:: 
:: to build and deploy application on minishift
::

@echo off
set docker_file_path=%1
set service_name=%2
shift
shift

echo docker_file_path:%docker_file_path%
echo service_name:%service_name%

:::::: LOGIN TO OPENSHIFT ENV :::::::::::

:: set docker environment variables to connect do Minishift docker daemon
echo minishift docker-env
@FOR /f "tokens=*" %%i IN ('minishift docker-env') DO @call %%i

:: login to openshift
echo oc login
oc login -u developer -p developer

:: login to the docker registry using the token from the currently logged-in openshift user
for /f "delims=" %%a in ('oc whoami') do @set username=%%a
for /f "delims=" %%a in ('oc whoami -t') do @set key=%%a

echo docker login with %username% and %key%
docker login -u %username% -p %key% 172.30.1.1:5000

:::::: BUILD :::::::::::

:: build source code to .jar file
call mvn clean package -Dmaven.test.skip=true

:: build the docker image
::docker-compose build
::docker build .
:: or using command : docker-compose build

:: tag the newly created docker image
:: docker tag a4628dc93c97 172.30.1.1:5000/myproject/%service_name%

:: build docker image and tag
docker build -t 172.30.1.1:5000/myproject/%service_name% .

:: push the image to the openshift docker registry
echo docker push
docker push 172.30.1.1:5000/myproject/%service_name%

:: verify that the image was uploaded
echo oc get istag
oc get istag

:::::: DEPLOY :::::::::::

:: create a new application from the uploaded image
echo oc new-app for %service_name%
oc new-app --image-stream=%service_name% --name=%service_name%

:: expose service for the new application
echo oc expose %service_name%
oc expose dc/%service_name% --port=8888

:: expose route for the new application -- only for gateway
echo oc expose %service_name%
oc expose svc/%service_name% --port=8888



