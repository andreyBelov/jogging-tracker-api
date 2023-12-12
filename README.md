# How to build and run

Check your JAVA_HOME variable
```bash
echo %JAVA_HOME%
echo $JAVA_HOME
```

If not set open command prompt as Admin:
```bash
setx /m JAVA_HOME "C:\Users\belov\.jdks\temurin-17.0.6"
export JAVA_HOME=/usr/lib/jvm/java-17
```

Make sure you are in the root of repo and run build plugin
```bash
.\mvnw spring-boot:build-image
./mvnw spring-boot:build-image
```

At the end of image building you will see in the console:

>"Successfully built image 'docker.io/library/jogging-tracker-api:0.0.1-SNAPSHOT'"
> 
>"BUILD SUCCESS"

Run postgres and app containers:
```bash
docker-compose up -d
```
Check containers started successfully:
```bash
docker ps -a
```
To stop containers:
```bash
docker-compose down -v
```
Open swagger ui http://localhost:8080/swagger-ui/index.html

At the first launch database will be prepopulated with one User record and one finished Run record for this user

# Tech features
- Open api specification: `http://localhost:8080/v3/api-docs` and swagger UI `http://localhost:8080/swagger-ui/index.html`
- Validation for request parameters with test coverage
- Exception handling
- Database migration management with code first approach and automated changelog generation
- For user statistics: streaming resultset of records one by one in order to avoid memory consumption leading to OutOfMemoryError
- Flexible specification-based approach for building dynamic sql queries
- Mapstruct-based mapping avoids Entity <-> DTO mapping boilerplate
# What can be done better
1) more tests
2) additional annotations to make OpenApiSpec clearer

# Task description
Rest API для бегового трекера

Реализовать Rest API для приложения. В рамках задания необязательно реализовывать аутентификацию.

Необходимо предусмотреть следующие Rest методы:

Добавление, редактирование, удаление пользователя, GET пользователя по id и GET всех пользователей списком. У пользователя должны быть следующие поля: id, first_name, last_name, birth_date, sex - все поля обязательные

Старт забега. В метод передается id пользователя, start_latitude, start_longitude, start_datetime

Завершение забега. В метод передаются id пользователя, finish_latitude, finish_longitude, finish_datetime, distance (преодоленное расстояние в метрах). Start и finish можно записывать в одну и ту же таблицу - runs. Опционально можно сделать, что если не передаем distance - метод сам высчитывает расстояние между стартовой и конечной точкой (будем считать в таком случае, что забег был по прямой линии)

Метод получения списках всех забегов для конкретного пользователя (по его id) с возможностью фильтрации по дате старта забега - from_datetime, to_datetime. В списке так же необходимо возвращать среднюю скорость для каждого забега.

Метод возвращения статистики по конкретному пользователю с возможностью фильтрации по дате старта забега - from_datetime, to_datetime. Возвращать нужно количество совершенных забегов, общее количество метров и среднюю скорость по всем забегам в выбранном периоде.



В качестве базы данных можно выбрать PostgreSQL или MongoDB.

Везде, где это необходимо нужно предусмотреть валидацию данных в передаваемых полях.

Unit тесты (если есть что тестировать) и интеграционные тесты (тесты которые тестируют само апи).