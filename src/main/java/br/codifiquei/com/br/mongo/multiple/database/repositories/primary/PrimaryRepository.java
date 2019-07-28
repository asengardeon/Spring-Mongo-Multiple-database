package br.codifiquei.com.br.mongo.multiple.database.repositories.primary;

import br.codifiquei.com.br.mongo.multiple.database.models.PrimaryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<PrimaryModel, String> {

}
