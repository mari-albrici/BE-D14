package entities;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "participation")
@Setter
@Getter
@NoArgsConstructor
@NamedQuery(name = "toBeConfirmedForEvent", query = "SELECT p FROM Participation p WHERE p.state = :unconfirmed")
public class Participation {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event", referencedColumnName = "id")
	private Event event;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person", referencedColumnName = "id")
	private Person person;

	
	@Enumerated(EnumType.STRING)
	private State state;
	
	public Participation(Person person, Event event, State state) {
		this.person = person;
		this.event = event;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return event + " " + state;
	}
}
