# Catalog Service

이 애플리케이션은 Polar Bookshop 시스템의 일부이며, 서점 카탈로그에서 책을 관리하는 기능을 제공합니다.
Cloud Native Spring in Action 도서의 일부로서, 토마스 비탈레(Thomas Vitale)가 진행한 프로젝트의 일부이기도 합니다.

## Useful Commands

| Gradle Command	         | Description                                   |
|:---------------------------|:----------------------------------------------|
| `./gradlew bootRun`        | 애플리케익션 실행.                                 |
| `./gradlew build`          | 애플리케이션을 빌드한다                             |
| `./gradlew test`           | 테스트 환경으로 실행.                              |
| `./gradlew bootJar`        | jar파일로 패키징                                  |
| `./gradlew bootBuildImage` | 컨테이너 이미지로 패키징 한다.                        |

After building the application, you can also run it from the Java CLI:

```bash
java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
```

## Container tasks

Run Catalog Service as a container

```bash
docker run --rm --name catalog-service -p 8080:8080 catalog-service:0.0.1-SNAPSHOT
```

### Container Commands

| Docker Command	              | Description       |
|:-------------------------------:|:-----------------:|
| `docker stop catalog-service`   | Stop container.   |
| `docker start catalog-service`  | Start container.  |
| `docker remove catalog-service` | Remove container. |

## Kubernetes tasks

### Create Deployment for application container

```bash
kubectl create deployment catalog-service --image=catalog-service:0.0.1-SNAPSHOT
```

### Create Service for application Deployment

```bash
kubectl expose deployment catalog-service --name=catalog-service --port=8080
```

### Port forwarding from localhost to Kubernetes cluster

```bash
kubectl port-forward service/catalog-service 8000:8080
```

### Delete Deployment for application container

```bash
kubectl delete deployment catalog-service
```

### Delete Service for application container

```bash
kubectl delete service catalog-service
```
