# Movie App

A Spring Boot REST API for managing movies, bookings, customers, genres, and seats, backed by MySQL.

## CI/CD Pipeline

The project uses **GitHub Actions** to automatically build, test, and publish a Docker image to **Docker Hub** on every push to `main`.

### Pipeline stages

| Job | Trigger | What it does |
|-----|---------|--------------|
| **Build & Test** | every push / PR to `main` or `develop` | Compiles with Maven, runs unit tests, uploads Surefire reports |
| **Docker Build & Push** | push to `main` only (after tests pass) | Builds multi-stage Docker image and pushes to Docker Hub |

### Required GitHub Secrets

Go to **Settings → Secrets and variables → Actions → New repository secret** and add:

| Secret name | Value |
|-------------|-------|
| `DOCKERHUB_USERNAME` | Your Docker Hub username |
| `DOCKERHUB_TOKEN` | A Docker Hub **Access Token** (not your password) — create one at https://hub.docker.com/settings/security |

### Docker image tags

Each successful `main` build produces two tags:

- `<username>/movie-app:latest`
- `<username>/movie-app:sha-<short-git-sha>`

### Running locally with Docker

```bash
docker pull <your-dockerhub-username>/movie-app:latest

docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/moviedb \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=secret \
  <your-dockerhub-username>/movie-app:latest
```

### Running with Maven

```bash
cd movie-app
./mvnw spring-boot:run
```

## Tech Stack

- Java 17 + Spring Boot 3.3.4
- Spring Data JPA + MySQL
- Maven
- Docker (multi-stage build, eclipse-temurin:17-jre-alpine runtime)
- GitHub Actions
