package app;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventDAO;
import dao.LocationDAO;
import dao.ParticipationDAO;
import dao.PersonDAO;
import entities.Concert;
import entities.EventType;
import entities.Gender;
import entities.Genre;
import entities.Location;
import entities.Participation;
import entities.Person;
import entities.State;
import entities.SoccerGame;
import entities.AthleticsCompetition;
import utils.JpaUtil;


public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();

		EventDAO ed = new EventDAO(em);
		PersonDAO pd = new PersonDAO(em);
		LocationDAO lp = new LocationDAO(em);
		ParticipationDAO pd1 = new ParticipationDAO(em);
		
		Location hotel = new Location("Marriott", "Milano");
		Location restaurant = new Location("Da Vittorio", "Bergamo");
		Location villa = new Location("Villa Malaguzzi", "Brescia");
		Location stadium = new Location("Lincoln Financial Field", "Philadelphia");
		
//		lp.save(villa);
//		lp.save(hotel);
//		lp.save(restaurant);
//		lp.save(stadium);
		
		
		Person alphaPerson = new Person("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1989, 6, 06), Gender.MALE, new HashSet<>());
		Person betaPerson = new Person("Luigia", "Rossi", "luigi.rossi@gmail.com", LocalDate.of(1998, 8, 06), Gender.FEMALE, new HashSet<>());
		Person carolinaKostner= new Person("Carolina", "Kostner", "icequeen@gmail.com", LocalDate.of(1987, 02, 8), Gender.FEMALE, new HashSet<>());
		
//		pd.save(betaPerson);
//		pd.save(alphaPerson);
		
		
		Concert taylorSwiftConcert = new Concert("Taylor Swift: the Eras Tour", LocalDate.of(2023, 6, 06), "Concert", EventType.PUBBLICO, 3000, hotel, new HashSet<>(), Genre.POP, true);
//		ed.save(taylorSwiftConcert);
//		logger.info(taylorSwiftConcert.getTitle() + " has been saved");
		
		SoccerGame championshipFinal = new SoccerGame("A vs B", LocalDate.of(2023, 12, 23), "Nation Championship Final", EventType.PRIVATO, 800, restaurant, new HashSet<>(), "A", "B", "A", 3, 1);
//		ed.save(championshipFinal);
//		logger.info(championshipFinal.getTitle() + " has been saved");
		
		AthleticsCompetition olympics = new AthleticsCompetition("Ice Skating Competition", LocalDate.of(2023, 6, 06), "Olympic Games", EventType.PRIVATO, 150, villa, new HashSet<>(), new HashSet<>(), carolinaKostner);
//		ed.save(olympics);
//		logger.info(olympics.getTitle() + " has been saved");
		
		
		Set<Participation> participations = new HashSet<>();
		
		Participation participationOne = new Participation(alphaPerson, taylorSwiftConcert, State.CONFIRMED);
		Participation participationTwo = new Participation(betaPerson, olympics, State.UNCONFIRMED);
		
//		participations.add(participationOne);
//		participations.add(participationTwo);
//		
//		pd1.save(participationOne);
//		pd1.save(participationTwo);

		logger.info("**********************************************************");
		logger.info("Concerts in streaming are: " + ed.getConcertsInStreaming());
		logger.info("POP concerts are: " + ed.getConcertsPerGenre(Genre.POP));
		
		logger.info("**********************************************************");
		logger.info("Won away games are: " + ed.getWonAwayGames());
		logger.info("Won home games are: " + ed.getWonHomeGames());
		logger.info("Tie games are: " + ed.getTieGames());
		
		logger.info("**********************************************************");
//		logger.info("The competitions won by ATHLETE are: " + ed.getCompetitionsPerWinner(carolinaKostner));
//		logger.info("The PERSON has participated in: " + ed.getCompetitionsPerParticipant(betaPerson));
		
		em.close();
		emf.close();

	}

}