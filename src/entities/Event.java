package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@MappedSuperclass
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Event {

	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	private LocalDate date;
	private String description;
	private EventType event_type;
	private int max_event_participants;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;
	
	@OneToMany(mappedBy="event", cascade = CascadeType.ALL)
	private Set<Participation> participants;
	

	public Event(String title, LocalDate date, String description, EventType event_type, int max_event_participants, Location location, Set<Participation> participants) {
		this.title = title;
		this.date = date;
		this.description = description;
		this.event_type = event_type;
		this.max_event_participants = max_event_participants;
		this.location = location;
		this.participants = participants;
	}


	@Override
	public String toString() {
		return title + " " + description + " " + "in data" + " " + date;
	}


}