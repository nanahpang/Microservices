# ACIDBrain

<p style="align: center">
    <img src="assets/README-263fd.png" width=30%></img>
</p>

A software application that applies Microservices architecture

# Build and run eventuate final deliverable using Docker compose
- go to final deliverable folder
    - cd eventuate/final deliverable
- build the application
    - ./gradlew assemble -P eventuateDriver=local
- export DOCKER_HOST_IP= your local machine ip
- launch application usin docker compose
    - docker-compose -f docker-compose-eventuate-local-mysql.yml up -d

# Build and run Axon final deliverable using Docker compose
- cd into axon-service directory:
    -build
        * `mvn clean install`

    -start
        * `docker-compose up -d --build`
        
    -stop
        * `docker-compose down --remove-orphans`
## TODOs

- Nimo:
    - Look at how to add plugin to Kong
    - Go through https://getkong.org/docs/0.10.x/plugin-development/distribution/
    - Learn Kong, Docker, Spring framework
- Nana:
    - Implement e-comerce system in eventuate
    - Go through http://eventuate.io/exampleapps.html
    - Learn Eventuate, Spring, AWS

## Tutorials

- Adding docker to AWS: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/docker-basics.html
- Spring project example repo: https://github.com/cloudframeworks-apigateway/springdata
- Eventuate example: http://eventuate.io/exampleapps.html

## Resources

- Final report:  https://docs.google.com/document/d/1X2q3e8XPLXCRlidIB-_euXKNGGPre2OrInVEXsDklD4/edit?usp=sharing

- Eventuate demo:
https://docs.google.com/document/d/16F6Zm_NIGKJGE1j2DMkEcWIHdgmALUyt0eaz4A89hhc/edit?usp=sharing

- Eventuate test urls
    - http://18.221.138.161:8081/swagger-ui.html create customer; get customer
    - http://18.221.138.161:8082/swagger-ui.html view customer history order; get order
    - http://18.221.138.161:8083/swagger-ui.html create order;
    - http://18.221.138.161:8084/swagger-ui.html create shipment
- Eventuate curl sample
    - see eventuate/test-eventuate.txt

- Eventuate slide:
https://www.slideshare.net/chris.e.richardson/a-pattern-language-for-microservices-gluecon-2016
- Presentation: https://docs.google.com/presentation/d/1UEZdzA1ftTM6Hj4YYuEuLEDKDaULurmaftdiqi5Ea2k/edit?usp=sharing


