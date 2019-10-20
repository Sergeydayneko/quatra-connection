# устанавливаем самую лёгкую версию JVM
FROM openjdk:8-jdk-alpine

# указываем ярлык. Например, разработчика образа и проч. Необязательный пункт.
LABEL maintainer="sergeydayneko@mail.ru"

# указываем точку монтирования для внешних данных внутри контейнера
VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8099

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=target/connection-0.0.1-SNAPSHOT.jar

# добавляем джарник в образ под именем rebounder-chain-backend.jar
ADD ${JAR_FILE} myConnection.jar

# команда запуска джарника
ENTRYPOINT ["java","-jar","/myConnection.jar"]
