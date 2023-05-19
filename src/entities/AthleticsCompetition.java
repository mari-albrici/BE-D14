package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@NamedQuery(name = "competitionsPerWinner", query = "SELECT ac FROM AthleticsCompetition ac WHERE ac.winner = :winner")
@NamedQuery(name = "competitionsPerParticipant", query = "SELECT ac FROM AthleticsCompetition ac WHERE ac.athleteSet = :name")

public class AthleticsCompetition extends Event{

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "athletes")
	private Set<Person> athleteSet;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Person winner;
	
	
	public AthleticsCompetition(String title, LocalDate date, String description, EventType event_type, int max_event_participants, Location location, Set<Participation> participants, Set<Person> athleteSet, Person winner){
		super(title, date, description, event_type, max_event_participants, location, participants);
		this.athleteSet = athleteSet;
		this.winner = winner;
		}
}
