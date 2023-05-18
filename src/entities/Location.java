package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
public class Location {

	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String city;
	
	public Location(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return name + " " + city;
	}
}

