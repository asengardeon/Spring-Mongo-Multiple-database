package br.codifiquei.com.br.Mongo.Multiple.database.configs;

import com.mongodb.MongoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;



@Configuration
@RequiredArgsConstructor
public class MultipleMongoConfig {

    @Autowired
    Environment env;

    @Primary
    @Bean(name = "primaryMongoTemplate")
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory());
    }

    @Bean(name = "secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        return new MongoTemplate(secondaryFactory());
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory() throws Exception {
        String host = env.getProperty("spring.data.mongodb.primary.host");
        String port = env.getProperty("spring.data.mongodb.primary.port");
        String database = env.getProperty("spring.data.mongodb.primary.database");
        return new SimpleMongoDbFactory(new MongoClient(host, Integer.valueOf(port)),
                database);
    }

    @Bean
    public MongoDbFactory secondaryFactory() throws Exception {
        String host = env.getProperty("spring.data.mongodb.secondary.host");
        String port = env.getProperty("spring.data.mongodb.secodary.port");
        String database = env.getProperty("spring.data.mongodb.secondary.database");
        return new SimpleMongoDbFactory(new MongoClient(host, Integer.valueOf(port)),
                database);
    }

}
