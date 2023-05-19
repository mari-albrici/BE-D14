package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_class", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "soldOutEvents", query = "SELECT e FROM Event e WHERE e.max_event_participants = :max_event_participants")
//@NamedQuery(name = "eventsPerGuest", query = "SELECT e FROM Event e WHERE e.participants @> :person")


public abstract class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private LocalDate date;
	private String description;
	private EventType event_type;
	private int max_event_participants;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;
	
	@OneToMany(cascade = CascadeType.ALL)
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