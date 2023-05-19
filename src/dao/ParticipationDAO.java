package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import entities.AthleticsCompetition;
import entities.Event;
import entities.Participation;

public class ParticipationDAO {

	private final EntityManager em;

	public ParticipationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Participation p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit(); 
	}
	
	public Participation getById(UUID id) {
		Participation foundParticipation = em.find(Participation.class, id); 
		return foundParticipation;

	}
	
	public List<Participation> getToBeConfirmedForEvent(Event event){
		TypedQuery<Participation> query = em.createNamedQuery("toBeConfirmedForEvent", Participation.class);
		query.setParameter("event", event);
		return query.getResultList();
	}
	
	
}
