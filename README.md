Details:
Project name - randomnumgenerator
in build.gradle, version is 0.0.1
dockerhub username: ganeshspark
port specified in application.properties: 9091
install java

Steps:
1. Clean with gradle
gradlew clean
2. Build with gradle
gradlew build
3. Make jar
java -jar build/libs/randomnumgenerator-0.0.1.jar
4. Create dockerfile with contents:
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

5. Build docker image passing the argument-jar file path, tag it with ur username/projectname
docker build --build-arg JAR_FILE=build/libs/randomnumgenerator-0.0.1.jar -t ganeshspark/randomnumgenerator .

6. verify image with docker image ls

7. build docker image with gradle(opt)
gradlew bootBuildImage --imageName=ganeshspark/randomnumgenerator

8. run the image on port 9091
docker run -d -p 9091:9091 -t ganeshspark/randomnumgenerator

9, Push to dockerhub(ensure docker login)
docker push ganeshspark/randomnumgenerator


docker run -d -p 9091:9091 --name=randomnumgenerator --network=messenger-network  ganeshspark/randomnumgenerator

docker inspect randomnumgenerator -f "{{json .NetworkSettings.Networks }}"

docker run -d -p 9090:9090  --network=messenger-network --name=messenger --env randomNumGeneratorUrl=http://randomnumgenerator:9091 ganeshspark/messenger

