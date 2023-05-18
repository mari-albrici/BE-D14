package app;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Event;
import entities.EventType;
import entities.Gender;
import dao.EventDAO;
import util.JPAutil;

import entities.Location;
import entities.State;
import entities.Participation;
import entities.Person;
import dao.LocationDAO;
import dao.ParticipationDAO;
import dao.PersonDAO;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JPAutil.getEntityManagerFactory();

	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();

		EventDAO ed = new EventDAO(em);
		PersonDAO pd = new PersonDAO(em);
		LocationDAO lp = new LocationDAO(em);
		ParticipationDAO pd1 = new ParticipationDAO(em);
		
		Location hotel = new Location("Marriott", "Milano");
		Location restaurant = new Location("Da Vittorio", "Bergamo");
		Location villa = new Location("Villa Malaguzzi", "Brescia");
		
		lp.save(villa);
		lp.save(hotel);
		lp.save(restaurant);
		
		
		Person alphaPerson = new Person("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1989, 6, 06), Gender.MALE, new HashSet<>());
		Person betaPerson = new Person("Luigia", "Rossi", "luigi.rossi@gmail.com", LocalDate.of(1998, 8, 06), Gender.FEMALE, new HashSet<>());
		
		pd.save(betaPerson);
		pd.save(alphaPerson);
		
		
		Event dinner = new Event("Gala Dinner", LocalDate.of(2023, 6, 06), "Beneficienza", EventType.PUBBLICO, 300, hotel, new HashSet<>());
		ed.save(dinner);
		logger.info(dinner.getTitle() + " has been saved");
		
		Event luncheon = new Event("Hollywood Luncheon", LocalDate.of(2023, 12, 23), "Beneficienza", EventType.PRIVATO, 800, restaurant, new HashSet<>());
		ed.save(luncheon);
		logger.info(luncheon.getTitle() + " has been saved");
		
		Event brunch = new Event("BYOD Brunch", LocalDate.of(2023, 6, 06), "Festa privata", EventType.PRIVATO, 150, villa, new HashSet<>());
		ed.save(brunch);
		logger.info(brunch.getTitle() + " has been saved");
		
		
		Set<Participation> participations = new HashSet<>();
		
		Participation participationOne = new Participation(alphaPerson, dinner, State.CONFIRMED);
		Participation participationTwo = new Participation(betaPerson, luncheon, State.UNCONFIRMED);
		
		participations.add(participationOne);
		participations.add(participationTwo);
		
		pd1.save(participationOne);
		pd1.save(participationTwo);



		em.close();
		emf.close();

	}

}