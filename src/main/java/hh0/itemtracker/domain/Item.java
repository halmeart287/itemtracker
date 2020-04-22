package hh0.itemtracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // Luodaan 'Item' -luokkaolio.
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Annotaatiot @Id ja @GeneratedValue automatisoivat olion 'id'
													// arvon.
	private Long itemId;
	private String name, time;

	@ManyToOne
	@JoinColumn(name = "trackId") // Monen suhde yhteen taulukkoyhteys 'Tracking' -luokkaolion kanssa.
	private Tracker tracker;

	// Konstruktorit

	public Item() {
		super();
		this.itemId = null;
		this.name = null;
		this.time = null;
		this.tracker = null;
	}

	public Item(Long itemId, String name, String time, Tracker tracker) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.time = time;
		this.tracker = tracker;
	}

	public Item(String name, String time, Tracker tracker) {
		super();
		this.name = name;
		this.time = time;
		this.tracker = tracker;
	}

	// Getterit ja Setterit

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Tracker getTracker() {
		return tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}

	// toString

	@Override
	public String toString() {
		if (this.tracker != null)
			return "Item [itemId=" + itemId + ", name=" + name + ", time=" + time + this.getTracker() + "]";
		else
			return "Item [itemId=" + itemId + ", name=" + name + ", time=" + time + "]";

	}

}
