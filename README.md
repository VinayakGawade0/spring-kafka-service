# Spring Kafka Service

This service is a Spring Boot application responsible for producing and consuming messages to and from Kafka topics.

## Features

- REST endpoints for producing and publishing Kafka messages.
- Integration with Apache Kafka broker.
- Configurable topic names, bootstrap servers, and Kafka properties.

## Prerequisites

- Java 17+ JDK
- Apache Kafka and Zookeeper running (typically on `localhost:9092` and `localhost:2181`)
- Maven (for building the project)

## Getting Started

### Clone and Navigate

```bash
git clone https://github.com/VinayakGawade0/spring-kafka-service.git
```

### Build the project

```bash
./mvnw clean install
```

### Run the application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## Available Endpoints

### POST /produce

Sends a message to the Kafka topic using one method.

**Request Body:**
```json
{
  "name": "John",
  "message": "Hello from /produce"
}
```

### POST /publish

Sends a message to the Kafka topic using an alternative method.

**Request Body:**
```json
{
  "name": "Jane",
  "message": "Hello from /publish"
}
```

## Configuration

All Kafka and Spring Boot properties can be configured in `src/main/resources/application.yml`.

## Notes

- This application expects Kafka to be running at `localhost:9092`.
- Customize topic name and other Kafka configurations in the properties file as needed.

---

## 📝 License

This project is licensed under the MIT License © Vinayak Gawade.
