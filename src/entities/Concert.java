package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@NamedQuery(name = "streamingConcerts", query = "SELECT c FROM Concert c WHERE c.inStreaming = true")
@NamedQuery(name = "concertsByGenre", query = "SELECT c FROM Concert c WHERE c.genre = :genre")
public class Concert extends Event{

	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre genre;
	
	@Column(name = "streaming")
	private boolean inStreaming; 
	
	
	public Concert(String title, LocalDate date, String description, EventType event_type, int max_event_participants, Location location, Set<Participation> participants, Genre genre, boolean inStreaming) {
		super(title, date, description, event_type, max_event_participants, location, participants);
		this.genre = genre;
		this.inStreaming = inStreaming;
	}
}
