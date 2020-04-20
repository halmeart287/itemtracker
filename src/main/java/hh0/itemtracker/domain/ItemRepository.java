package hh0.itemtracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

	// Luodaan lista Item-luokkaolioista repositoriota varten, josta tiedot haetaan. JSON.
	List<Item> findByName(String name);

}
