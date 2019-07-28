package br.codifiquei.com.br.mongo.multiple.database.configs;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;



@Configuration
public class MultipleMongoConfig {

    @Autowired
    private Environment env;

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
    protected MongoDbFactory primaryFactory() throws Exception {
        String host = env.getProperty("spring.data.mongodb.primary.host", "localhost");
        String port = env.getProperty("spring.data.mongodb.primary.port", "27017");
        String database = env.getProperty("spring.data.mongodb.primary.database", "");
        return new SimpleMongoDbFactory(new MongoClient(host, Integer.valueOf(port)),
                database);
    }

    @Bean
    protected MongoDbFactory secondaryFactory() throws Exception {
        String host = env.getProperty("spring.data.mongodb.secondary.host", "localhost");
        String port = env.getProperty("spring.data.mongodb.secondary.port", "27017");
        String database = env.getProperty("spring.data.mongodb.secondary.database", "");
        return new SimpleMongoDbFactory(new MongoClient(host, Integer.valueOf(port)),
                database);
    }

}
