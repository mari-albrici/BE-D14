package entities;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@NamedQuery(name = "wonHomeGames", query = "SELECT sg FROM SoccerGame sg WHERE sg.winningTeam = :homeTeam")
@NamedQuery(name = "wonAwayGames", query = "SELECT sg FROM SoccerGame sg WHERE sg.winningTeam = :awayTeam")
@NamedQuery(name = "tieGames", query = "SELECT sg FROM SoccerGame sg WHERE sg.winningTeam IS null")

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
	
	public SoccerGame(String title, LocalDate date, String description, EventType event_type, int max_event_participants, Location location, Set<Participation> participants, String homeTeam, String awayTeam, String winningTeam, int homeTeamPoints, int awayTeamPoints) {
		super(title, date, description, event_type, max_event_participants, location, participants);
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winningTeam = winningTeam;
		this.homeTeamPoints = homeTeamPoints;
		this.awayTeamPoints = awayTeamPoints;
	}
}
