# ACIDBrain

<p align="center">
    <img src="assets/README-263fd.png" width=40%></img>
</p>

The ACIDBrain team investigates ways to maintain data consistency in microservices applications. We built prototypes in two popular frameworks, [Axon](http://www.axonframework.org/) and [Eventuate](http://eventuate.io/), and tested their usability from __an end-user's perspective__ both quantitatively and qualitatively. This repo contains the source code of both prototypes and tests we ran on them.

- `prototype`: initial prototype _without_ any data consistency guarantees.
- `axon-service`: the Axon prototype
- `eventuate`: the Eventuate prototype
- `docs`: initial proposal and final report. Also see the [Past Milestones](#past-milestones) for other documents we created throughout the semester.
- `test`: scripts for load testing the applications. They are written to be used by [Artillery](https://artillery.io/) and has to be modified manually due to some server-side setup do generate different customer ID and IP addresses each time before we run the whole test suite.
- `assets`: images and diagrams

# Build and run Eventuate final deliverable using Docker compose

- Go to final deliverable folder
    - `cd eventuate/final\ deliverable`
- Build the application
    - `./gradlew assemble -P eventuateDriver=local`
- Set the host IP of docker:
    - `export DOCKER_HOST_IP= <your-local-machine-ip>`
- Launch application using `docker-compose`
    - `docker-compose -f docker-compose-eventuate-local-mysql.yml up -d`

# Running Eventuate sample on AWS

- We also deployed Eventuate on AWS for testing purposes, and we do not, unfortunately, host the Axon services simultaneously.
- Eventuate test urls
    - http://18.188.46.123:8081/swagger-ui.html create customer; get customer
    - http://18.188.46.123:8082/swagger-ui.html view customer history order; get order
    - http://18.188.46.123:8083/swagger-ui.html create order;
    - http://18.188.46.123:8084/swagger-ui.html create shipment
- Eventuate `curl` sample
    - see `eventuate/test-eventuate.txt` for relevant commands and API format

# Build and run Axon final deliverable using Docker compose

- Go to axon-service directory:
    - `cd axon-service`
- Build: `mvn clean install`
- Start: `docker-compose up -d --build`
- Stop: `docker-compose down --remove-orphans`

## Resources

### Past Milestones

- Final report:  https://docs.google.com/document/d/1X2q3e8XPLXCRlidIB-_euXKNGGPre2OrInVEXsDklD4/edit?usp=sharing

- Eventuate demo:
https://docs.google.com/document/d/16F6Zm_NIGKJGE1j2DMkEcWIHdgmALUyt0eaz4A89hhc/edit?usp=sharing

- Presentation: https://docs.google.com/presentation/d/1UEZdzA1ftTM6Hj4YYuEuLEDKDaULurmaftdiqi5Ea2k/edit?usp=sharing

### Tutorials

- Adding docker to AWS: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/docker-basics.html
- Spring project example repo: https://github.com/cloudframeworks-apigateway/springdata
- Eventuate example: http://eventuate.io/exampleapps.html
- Eventuate slides:
https://www.slideshare.net/chris.e.richardson/a-pattern-language-for-microservices-gluecon-2016
