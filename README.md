## Rezolve Instant Sales - Dante's Challenge

### Requirements:
- Docker
- Java 8+
- Docker-compose?
  - Install on linux:
    - sudo curl -L https://github.com/docker/compose/releases/download/1.29.1/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
    - sudo chmod +x /usr/local/bin/docker-compose   

### How to run project on Linux:
- ./gradlew clean build -x test
- docker-compose build
- docker-compose up

### Testing API's

- Postman:
  - Import files in Postman:
    - Collection of tests: /test/resource/postman/challenge.postman_collection.json
    - Enviroment: /test/resource/postman/challenge.postman_environment.json

### Developers

- Dante Cesar Basso Filho <dcbasso@gmail.com>
