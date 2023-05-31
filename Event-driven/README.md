This project demonstrates Kafka functionalities with differnet microservices

Order service places an order and push to the kafka queue as producer with different topics.
Both Email and Stock service consumes the event based on the topic they are listening to.
