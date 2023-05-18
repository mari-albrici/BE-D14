package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
public class Person {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	private String lastname;
	private String email;
	private LocalDate birthday;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToMany(mappedBy = "person")
	@OrderBy("date DESC")
	private Set<Participation> eventParticipation;
	
	public Person(String name, String lastname, String email, LocalDate birthday, Gender gender, Set<Participation> eventParticipation) {
		this.name = name;
		this.lastname = lastname;
		this.birthday = birthday;
		this.email = email;
		this.gender = gender;
		this.eventParticipation = eventParticipation;
	}
	
	@Override
	public String toString() {
		return name + " " + lastname + " " + birthday + " " + email + " " + gender;
	}

}
