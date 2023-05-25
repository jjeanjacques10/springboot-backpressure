# Pokemon Center - Backpressure

![https://i.ytimg.com/vi/8RJZIEVsDVE/hqdefault.jpg](https://i.ytimg.com/vi/8RJZIEVsDVE/hqdefault.jpg)

Demo project for Spring Boot using Backpressure with MySQL.

## Technologies

- Kotlin
- Spring Boot
- SQS

## Backpressures

- [DBHealthyBackpressure.kt](./src/main/kotlin/com/jjeanjacques/pokemoncenter/adapter/queue/backpressure/DBHealthyBackpressure.kt)

Check the database health (status). Such as "UP", "DOWN" or "OUT_OF_SERVICE".

- [DBHealthyConnectionsBackpressure.kt](./src/main/kotlin/com/jjeanjacques/pokemoncenter/adapter/queue/backpressure/DBHealthyConnectionsBackpressure.kt)

Check the number of connections in the database, if there are more than 30 connections, the application will wait.

## Running local

```
-Dspring.profiles.active=local
```

## Create Messages

```
aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{\"name\":\"Pikachu\",\"type\":\"ELECTRIC\",\"hp\":100,\"level\":50,\"master\":\"red\"}'
aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{\"name\":\"Charizard\",\"type\":\"FIRE\",\"hp\":150,\"level\":65,\"master\":\"red\"}'
aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{\"name\":\"Blastoise\",\"type\":\"WATER\",\"hp\":120,\"level\":60,\"master\":\"red\"}'
```

Or

``` bash
#!/bin/bash
for ((i=1; i<=2; i++))
do
    aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{"name":"Pikachu","type":"ELECTRIC","hp":100,"level":50, "master": "red"}'
    aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{"name":"Charizard","type":"FIRE","hp":150,"level":65, "master": "red"}'
    aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{"name":"Blastoise","type":"WATER","hp":120,"level":60, "master": "red"}'
done
```

## References

- [Backpressure em filas - Evitando a DLQ](https://www.youtube.com/watch?v=gK4FBDPDPVw)
- [RicardoRFaria/demo-filas](https://github.com/RicardoRFaria/demo-filas)
- [localstack - init hooks](https://docs.localstack.cloud/references/init-hooks/)