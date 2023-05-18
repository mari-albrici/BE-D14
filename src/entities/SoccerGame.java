package entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class SoccerGame extends Event{

	@Column(name = "home_team")
	private String homeTeam;
	
	@Column(name = "away_team")
	private String awayTeam;
	
	@Column(name = "winning_team")
	private String winningTeam;
	
	@Column(name = "home_team_points")
	private int homeTeamPoints;
	
	@Column(name = "away_team_points")
	private int awayTeamPoints;
	
	public SoccerGame(String homeTeam, String awayTeam, String winningTeam, int homeTeamPoints, int awayTeamPoints) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winningTeam = winningTeam;
		this.homeTeamPoints = homeTeamPoints;
		this.awayTeamPoints = awayTeamPoints;
	}
}
