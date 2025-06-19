#Match odds api

A Springboot REST API for managing betting matches between 2 teams, where you can make CRUD operations.

---

## Tech stack

- Java 17
- Springboot 3.5
- Postgresql
- Maven
- Docker

---

## How to run

### Option 1: Run with Docker

1. Instal Docker and Docker compose.
2. In the project root where Dockerfile and docker-compose.yml are (/match-odds-api) run in the terminal docker-compose up --build
3. App runs at: http://localhost:8080/ (please check the exported collection to test the endpoints)

### Option 2: Run locally

1. Install java 17, postgresql
2. Uncomment the credentials in application.properties under the comment //uncomment to run locally. If you do so, make sure to comment out the docker credentials to set the database connection.
3. Run mvn clean package -DskipTests
4. Run java -jar target/match-odds-api-0.0.1-SNAPSHOT.jar
5. App runs at: http://localhost:8080/

## Project structure

### /controller : REST endpoints

### /service : business logic

### /model : entities

### /repositories : JPA repositories

### /enums : enum for sporttype

## Other

### db credentials are set in docker -> username : panos , password : password
