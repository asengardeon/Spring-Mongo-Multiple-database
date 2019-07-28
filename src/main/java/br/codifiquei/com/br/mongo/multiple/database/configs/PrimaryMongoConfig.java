package br.codifiquei.com.br.mongo.multiple.database.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.codifiquei.com.br.mongo.multiple.database.repositories.primary", mongoTemplateRef = "primaryMongoTemplate")
@Profile("primario")
public class PrimaryMongoConfig {

}