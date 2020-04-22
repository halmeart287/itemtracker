package hh0.itemtracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh0.itemtracker.domain.Item;
import hh0.itemtracker.domain.ItemRepository;
import hh0.itemtracker.domain.Tracker;
import hh0.itemtracker.domain.TrackerRepository;
import hh0.itemtracker.domain.User;
import hh0.itemtracker.domain.UserRepository;

@SpringBootApplication
public class ItemTrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(ItemTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ItemTrackerApplication.class, args);
	}

	// Esimerkkidataa bean-annotaation avulla. Ladataan heti sivun avautuessa ja
	// asetellaan items.html-tiedostoon.
	@Bean
	public CommandLineRunner itemDemoData(ItemRepository itemRepository, TrackerRepository trackerRepository,
			UserRepository userRepository) {
		return (args) -> {
			log.info("tallenetaan muutama esimerkki 'Item' sekä 'Tracking' arvot.");

			trackerRepository.save(new Tracker("Yes"));
			trackerRepository.save(new Tracker("No"));

			itemRepository.save(new Item("Lemonette", "06:00", trackerRepository.findByTrack("Yes").get(0)));
			itemRepository.save(new Item("Adamantite Ore", "12:00", trackerRepository.findByTrack("No").get(0)));
			itemRepository.save(new Item("Dravanian Bass", "12:00", trackerRepository.findByTrack("No").get(0)));

			// Luodaan väliaikaiset käyttäjät
			User user1 = new User("user", "$2y$12$ir1tTOe.NslMiWQ6xfGzbeo4l0gCSvS4oPaMc81JLk8yHc847Hef2", "USER"); // tavis
			User user2 = new User("admin", "$2y$12$Of.UuJyPZLjWdp/pLsw08.7iYMtP5a7VwJfBwoM1TGcLUJN74rqr.", "ARTTU"); // arttu
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("haetaan kaikki 'tracking' -arvot");
			for (Tracker tracker : trackerRepository.findAll()) {
				log.info(tracker.toString());
			}
		};
	}

}
