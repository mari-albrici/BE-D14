package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Person;

public class PersonDAO {

	private final EntityManager em;

	public PersonDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Person pe) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(pe);
		transaction.commit(); 
	}

}
