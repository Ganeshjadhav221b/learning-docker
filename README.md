<h1>Project Details</h1>

```
Project name - randomnumgenerator
in build.gradle, version for application is 0.0.1
dockerhub username: ganeshspark
port specified in application.properties: 9091
install java
```
Steps:
1. Clean with gradle<br>
`gradlew clean`
2. Build with gradle->produced jar file under build/libs<br>
`gradlew build`
3. Run jar<br>
`java -jar build/libs/randomnumgenerator-0.0.1.jar`
4. Create dockerfile<br>

5. Build docker image passing the argument-jar file path, tag it with ur username/projectname<br>
`docker build --build-arg JAR_FILE=build/libs/randomnumgenerator-0.0.1.jar -t ganeshspark/randomnumgenerator .`

6. verify image with<br> `docker image ls`

7. build docker image with gradle(optional)<br>
`gradlew bootBuildImage --imageName=ganeshspark/randomnumgenerator`

8. run the image on port 9091<br>
`docker run -d -p 9091:9091 -t ganeshspark/randomnumgenerator`

9, Push to dockerhub(ensure docker login)<br>
`docker push ganeshspark/randomnumgenerator`

<b>Other commands(work in progress)</b><br>
To have the container run on network<br>
`docker run -d -p 9091:9091 --name=randomnumgenerator --network=messenger-network  ganeshspark/randomnumgenerator`

Get details about the network of the running container<br>
`docker inspect randomnumgenerator -f "{{json .NetworkSettings.Networks }}"`

To make other microservice communicate with the randomnumgenerator service<br>
`docker run -d -p 9090:9090  --network=messenger-network --name=messenger --env randomNumGeneratorUrl=http://randomnumgenerator:9091 ganeshspark/messenger`

