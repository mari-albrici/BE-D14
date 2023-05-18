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
public class Concert extends Event{

	@Column(name = "genre")
	private Genre genre;
	
	@Column(name = "streaming")
	private boolean inStreaming; 
	
	
	public Concert(Genre genre, boolean inStreaming) {
		super();
		this.genre = genre;
		this.inStreaming = inStreaming;
	}
}
