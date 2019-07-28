package br.codifiquei.com.br.Mongo.Multiple.database.repositories.primary;

import br.codifiquei.com.br.Mongo.Multiple.database.models.PrimaryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<PrimaryModel, String> {

}
