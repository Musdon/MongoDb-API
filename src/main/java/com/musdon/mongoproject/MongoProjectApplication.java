package com.musdon.mongoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.musdon.mongoproject.repository")
public class MongoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoProjectApplication.class, args);
    }

}
