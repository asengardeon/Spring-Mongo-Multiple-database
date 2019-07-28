package br.codifiquei.com.br.mongo.multiple.database;

import br.codifiquei.com.br.mongo.multiple.database.models.PrimaryModel;
import br.codifiquei.com.br.mongo.multiple.database.repositories.primary.PrimaryRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MongobootstrapApplicationTests {

	@Autowired
	private PrimaryRepository primaryRepository;

	@Autowired
	private Environment env;

	private static Logger logger = LoggerFactory.getLogger(MongobootstrapApplication.class);

	@BeforeClass
	public static void beforeClass(){

	}

	@Test
	public void contextLoads() {
		this.primaryRepository.save(new PrimaryModel(null, "Primary database plain object"));

//		this.secondaryRepository.save(new SecondaryModel(null, "Secondary database plain object"));

		List<PrimaryModel> primaries = this.primaryRepository.findAll();
		for (PrimaryModel primary : primaries) {
			logger.info(primary.toString());
		}
	}

}
