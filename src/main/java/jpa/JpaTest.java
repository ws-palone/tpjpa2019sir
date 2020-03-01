package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import model.*;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {

			Allergy arachide = new Allergy();
			arachide.setName("Arachide");
			Preference legumes = new Preference();
			legumes.setName("Legumes");

			Person p1 = new Person();
			p1.setMail("p1@mail.com");
			p1.setFirstName("p1");
			p1.setLastName("Np1");
			manager.persist(p1);

			Person p2 = new Person();
			p2.setMail("p2@mail.com");
			p2.setFirstName("p2");
			p2.setLastName("Np2");
			manager.persist(p2);

			Person p3 = new Person();
			p3.setMail("p3@mail.com");
			p3.setFirstName("p3");
			p3.setLastName("Np3");
			List<Preference> p3preferences = new ArrayList<Preference>();
			p3preferences.add(legumes);
			legumes.addPerson(p3);
			manager.persist(p3);

			Person p4 = new Person();
			p4.setMail("p4@mail.com");
			p4.setFirstName("p4");
			p4.setLastName("Np4");
			List<Allergy> p4Allergys = new ArrayList<Allergy>();
			p4Allergys.add(arachide);
			arachide.addPerson(p4);
			manager.persist(p4);

			Person p5 = new Person();
			p5.setMail("p5@mail.com");
			p5.setFirstName("p5");
			p5.setLastName("Np5");
			manager.persist(p5);

			manager.persist(legumes);
			manager.persist(arachide);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}