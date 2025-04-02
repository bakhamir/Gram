# Gram
## the chat platform for sprng java stuffs
## not a teleGRAM ripoff
vector was involved in the making of this proj
TODO

примерная структура которую нужно реализовать

backend/
│── src/main/java/com/example/chat/
│   ├── config/            # Конфигурационные классы (Spring Security, WebSockets, Kafka и т. д.)
│   ├── controller/        # REST API и WebSocket контроллеры
│   ├── service/           # Бизнес-логика
│   ├── repository/        # Репозитории (Spring Data JPA)
│   ├── model/             # JPA-сущности и DTO
│   ├── security/          # JWT/OAuth2 безопасность
│   ├── events/            # Kafka-события
│   ├── utils/             # Вспомогательные классы
│── src/main/resources/
│   ├── application.yml    # Конфигурация Spring Boot
│   ├── logback.xml        # Логирование
│── pom.xml 
│── Dockerfile             # Контейнеризация
│── kubernetes/            # K8s манифесты 
