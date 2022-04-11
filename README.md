Performance test

```console
docker network create my-net

docker run --rm -p 3306:3306 --name mysql --net=my-net -e MYSQL_ROOT_PASSWORD=rootpass -e MYSQL_USER=db_user -e MYSQL_PASSWORD=db_pass -e MYSQL_DATABASE=sample-db -d mysql:5.6.51

./gradlew clean build

docker build -t sample-app:tuningId .

docker run --rm -d -p 8080:30001 -e MYSQL_HOST=mysql --name sample-app --net=my-net sample-app:tunningId
```

getting ready to read data

```console
docker logs -f sample-app
docker stats
```

start tests

```console
ab -n 1000 -c 3 http://localhost:8080/users/random
```


More testing
```console
<<DROP TABLES FROM DATABASE>>>
docker run --rm -d -p 8080:30001 -e MYSQL_HOST=mysql -e DB_CONN_TIMEOUT=4000 -e DB_POOL_SIZE=30 --name sample-app --net=my-net sample-app:tuningId
```

Time to change from UUID to long(go to user entity and comment UUID stuff and uncomment long ID)

```console
./gradlew clean build

docker build -t sample-app:tuningId2 .

<<DROP TABLES FROM DATABASE>>>

docker run --rm -p 3306:3306 --name mysql --net=my-net -e MYSQL_ROOT_PASSWORD=rootpass -e MYSQL_USER=db_user -e MYSQL_PASSWORD=db_pass -e MYSQL_DATABASE=sample-db -d mysql:5.6.51

docker run --rm -p 8080:30001 -e MYSQL_HOST=mysql --name sample-app --net=my-net sample-app:tuningId2
```
