package hh0.itemtracker.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrackerRepository extends CrudRepository<Tracker, Long> {
	
	List<Tracker> findByTrack(String track);

}
