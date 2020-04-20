package hh0.itemtracker.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tracker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trackId;
	private String track;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tracker")
	private List<Item> items;

	public Tracker() {
		super();
		this.trackId = null;
		this.track = null;
	}

	public Tracker(Long trackId, String track) {
		super();
		this.trackId = trackId;
		this.track = track;
	}

	public Tracker(String track) {
		super();
		this.track = track;
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Tracker [trackId=" + trackId + ", track=" + track + "]";
	}

}
