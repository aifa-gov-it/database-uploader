# XML Invoice Processor

## Build

### Manual Build Process

#### Dependencies

- Java JDK 8+
- Maven 3.3.9+

#### Procedure

You can build the source by running `mvn install` from the root of the project.

### Dockerized Build Process

You can use a container to build the source if you don't want to install build dependencies. You only need to have Docker installed.

#### Dependencies

- Docker: 1.12+

#### Procedure

Run the build container, from the root of the project: `docker run -it -v $(pwd):/usr/src/app -w /usr/src/app --rm maven:3.3.9-jdk-8 mvn install`
