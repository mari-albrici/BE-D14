package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AthleticsCompetition extends Event{

	@Column(name = "athletes")
	private Set<Person> athleteSet;
	
	@Column(name = "winner")
	private Person winner;
	
	
	public AthleticsCompetition(Set<Person> athleteSet, Person winner){
		super();
		this.athleteSet = athleteSet;
		this.winner = winner;
		}
}
