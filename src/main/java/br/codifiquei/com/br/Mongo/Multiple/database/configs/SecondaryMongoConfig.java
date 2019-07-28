package br.codifiquei.com.br.Mongo.Multiple.database.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.codifiquei.com.br.Mongo.Multiple.database.repositories.secondary", mongoTemplateRef = "secondaryMongoTemplate")
public class SecondaryMongoConfig {

}
