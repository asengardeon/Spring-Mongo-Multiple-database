package br.codifiquei.com.br.Mongo.Multiple.database.repositories.secondary;

import br.codifiquei.com.br.Mongo.Multiple.database.models.SecondaryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<SecondaryModel, String> {

}
