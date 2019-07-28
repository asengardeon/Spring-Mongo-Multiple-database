package br.codifiquei.com.br.mongo.multiple.database;

import br.codifiquei.com.br.mongo.multiple.database.models.PrimaryModel;
import br.codifiquei.com.br.mongo.multiple.database.models.SecondaryModel;
import br.codifiquei.com.br.mongo.multiple.database.repositories.primary.PrimaryRepository;
import br.codifiquei.com.br.mongo.multiple.database.repositories.secondary.SecondaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class MongobootstrapApplication implements CommandLineRunner {

	@Autowired
	private PrimaryRepository primaryRepository;

	@Autowired
	private SecondaryRepository secondaryRepository;

	private static Logger logger = LoggerFactory.getLogger(MongobootstrapApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MongobootstrapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("************************************************************");
		logger.info("Start printing mongo objects");
		logger.info("************************************************************");
		this.primaryRepository.save(new PrimaryModel(null, "Primary database plain object"));

		this.secondaryRepository.save(new SecondaryModel(null, "Secondary database plain object"));

		List<PrimaryModel> primaries = this.primaryRepository.findAll();
		for (PrimaryModel primary : primaries) {
			logger.info(primary.toString());
		}

		List<SecondaryModel> secondaries = this.secondaryRepository.findAll();

		for (SecondaryModel secondary : secondaries) {
			logger.info(secondary.toString());
		}

		logger.info("************************************************************");
		logger.info("Ended printing mongo objects");
		logger.info("************************************************************");
	}
}
