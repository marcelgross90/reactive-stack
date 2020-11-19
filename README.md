# Prove of Concept Reactive Stack with Spring & Kotlin

In this project we would like to find out the way of how the reactive stack of Spring works.
Therefore we build a reactive pipelines with rabbitmq to send messages from a publisher via a processor to a subscriber.



## Idea of the project

This example is based on the idea of the concept of continuous deployment.


The components are:
- publisher which represents a repository in this example Gitlab
- processor which represents a build server
- subscriber which represents a application server


### Publisher

This represents a code repository in this example Gitlab.
We have a component (Developer) which pushes a commit to it. (Generation of data)
These commits will now be published

### Processor

This represents a build server.
The processor will listen two the published commits and start a build.
In the first part a commit will be transformed into an artefact.
The second part will add a version to this artefact.
After the artefact is complete the processor will publish this artefact.

### Subsriber

This represents an application server.
The application server will listion to any published artefacts and run them.

## Prerequisites

### Setup with Docker

1. docker
2. docker-compose

### Setup without Docker

1. JDK 11
2. gradle 6.6.1
3. rabbitmq

## Getting started

### Start with Docker

#### Start the whole projekct in docker

    $ make # docker-compose up --force-recreate --build
   
#### Start only the required services without the spring applications

This a good opportunaty if you like to start the services e.g. via IDE but you need all the other requiered services up and running.

    $ make service # docker-compose up --scale subscriber=0 --scale processor=0 --scale publisher=0

### Start without Docker

To start this project without Docker you need to need to have a running rabbitmq service.
Build each service (Publisher, Processor, Subsriber) with gradle

    $ ./gradlew build

Start each jar, best in the order:
1. Subscriber
2. Processor
3. Publisher

    $ java -jar [JARNAME].jar

