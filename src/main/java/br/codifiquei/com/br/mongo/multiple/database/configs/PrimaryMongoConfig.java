package br.codifiquei.com.br.mongo.multiple.database.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.codifiquei.com.br.mongo.multiple.database.repositories.primary", mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {

}