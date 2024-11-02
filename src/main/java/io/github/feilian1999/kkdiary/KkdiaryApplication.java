package io.github.feilian1999.kkdiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KkdiaryApplication {

	private static final Logger log = LoggerFactory.getLogger(KkdiaryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KkdiaryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RevisionRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Revision("Jack", "Bauer", 0, 1));
			repository.save(new Revision("Chloe", "O'Brian", 2, 1));
			repository.save(new Revision("Kim", "Bauer", 1, 3));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(revision -> {
				log.info(revision.toString());
				log.info(revision.getCorrection());
			});
			System.out.println(repository.findByCorrection("Chloe"));
		};
	}
}
