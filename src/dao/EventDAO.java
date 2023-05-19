package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Concert;
import entities.Event;
import entities.Genre;
import entities.Person;
import entities.SoccerGame;
import entities.AthleticsCompetition;

public class EventDAO {

	private final EntityManager em;

	public EventDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Event e) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(e);
		transaction.commit(); 
	}

	public Event getById(long id) {
		Event foundEvent = em.find(Event.class, id); 
		return foundEvent;

	}

	public void refresh(long id) {
		Event foundEvent = em.find(Event.class,id);
		foundEvent.setTitle("Hollywood Breakfast");
		System.out.println(foundEvent);
		System.out.println("PRE REFRESH");
		em.refresh(foundEvent);
		System.out.println("POST REFRESH");
		System.out.println(foundEvent);
	}
	
	public void findByIdAndDelete(long id) {
		Event foundEvent = em.find(Event.class,id);
		if(foundEvent != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(foundEvent);
			transaction.commit();
			System.out.println("Deleted event");
		}else {
			System.out.println("Could not delete a non-existent event");
		}
	}
	
	public List<Concert> getConcertsInStreaming() {
		TypedQuery<Concert> query = em.createNamedQuery("streamingConcerts", Concert.class);
		return query.getResultList();
	}
	
	public List<Concert> getConcertsPerGenre(Genre genre) {
		TypedQuery<Concert> query = em.createNamedQuery("concertsByGenre", Concert.class);
		query.setParameter("genre", genre);
		return query.getResultList();
	}
	
	public List<SoccerGame> getWonAwayGames() {
		TypedQuery<SoccerGame> query = em.createNamedQuery("wonAwayGames", SoccerGame.class);
		if(query.getResultList().isEmpty()) {
			System.out.println("NO AWAY GAMES WERE WON");
		}
		return query.getResultList();
	}
	
	public List<SoccerGame> getWonHomeGames() {
		TypedQuery<SoccerGame> query = em.createNamedQuery("wonHomeGames", SoccerGame.class);
		if(query.getResultList().isEmpty()) {
			System.out.println("NO HOME GAMES WERE WON");
		}
		return query.getResultList();
	}
	
	public List<SoccerGame> getTieGames() {
		TypedQuery<SoccerGame> query = em.createNamedQuery("tieGames", SoccerGame.class);
		if(query.getResultList().isEmpty()) {
			System.out.println("NO GAMES WERE TIED");
		} else {
			return query.getResultList();
		}
		return null;
	}
	
	public List<AthleticsCompetition> getCompetitionsPerWinner(Person winner){
		TypedQuery<AthleticsCompetition> query = em.createNamedQuery("competitionsPerWinner", AthleticsCompetition.class);
		query.setParameter("winner", winner);
		return query.getResultList();
	}
	
	public List<AthleticsCompetition> getCompetitionsPerParticipant(Person person){
		TypedQuery<AthleticsCompetition> query = em.createNamedQuery("competitionsPerParticipant", AthleticsCompetition.class);
		query.setParameter("athleteSet", person);
		return query.getResultList();
	}
//	
//	public List<Event> getSoldOutEvents(){
//		TypedQuery<Event> query = em.createNamedQuery("soldOutEvents", Event.class);
//		return query.getResultList();
//	}
//	
//	public List<Event> getEventsByGuest(Person person){
//		TypedQuery<Event> query = em.createNamedQuery("eventsPerGuest", Event.class);
//		query.setParameter("participants", person);
//		return query.getResultList();
//	}
}