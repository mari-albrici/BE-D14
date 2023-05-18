package entities;

import java.util.Set;

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

	@OneToMany
	@Column(name = "athletes")
	private Set<Person> athleteSet;
	
	@OneToOne
	private Person winner;
	
	
	public AthleticsCompetition(Set<Person> athleteSet, Person winner){
		super();
		this.athleteSet = athleteSet;
		this.winner = winner;
		}
}
