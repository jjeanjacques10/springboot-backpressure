# Pokemon Center - Backpressure

Demo project for Spring Boot using Backpressure with MySQL.

## Technologies

- Kotlin
- Spring Boot
- SQS

## Backpressure

- [DBHealthyBackpressure](./src/main/kotlin/com/jjeanjacques/pokemoncenter/adapter/queue/backpressure/DBHealthyBackpressure.kt)

## Running local

```
-Dspring.profiles.active=local
```

## Create Messages

```
aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{\"name\":\"Pikachu\",\"type\":\"ELECTRIC\",\"hp\":100,\"level\":50}'
aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{\"name\":\"Charizard\",\"type\":\"FIRE\",\"hp\":150,\"level\":65}'
aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{\"name\":\"Blastoise\",\"type\":\"WATER\",\"hp\":120,\"level\":60}'
```

Or

``` bash
#!/bin/bash
for ((i=1; i<=2; i++))
do
    aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{"name":"Pikachu","type":"ELECTRIC","hp":100,"level":50}'
    aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{"name":"Charizard","type":"FIRE","hp":150,"level":65}'
    aws sqs send-message --queue-url http://localhost:4576/000000000000/sick-pokemon-queue --endpoint-url=http://localhost:4576 --message-body '{"name":"Blastoise","type":"WATER","hp":120,"level":60}'
done
```

## References

- [Backpressure em filas - Evitando a DLQ](https://www.youtube.com/watch?v=gK4FBDPDPVw)
- [RicardoRFaria/demo-filas](https://github.com/RicardoRFaria/demo-filas)