package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Event;

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
}