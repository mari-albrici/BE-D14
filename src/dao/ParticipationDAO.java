package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
