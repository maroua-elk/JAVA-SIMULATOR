// importation des packages
package Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class Hibernate_framework extends simulateur {
	private EntityManager em;
	private static int ID_SEQ = 10;

	public Hibernate_framework() {
		em = Persistence.createEntityManagerFactory("default").createEntityManager();
		delete();
	}

	@Override
	public void create() {
		hibernateEntity user = new hibernateEntity("12012022", 852, 14, "MAR", 7.95);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		ID_SEQ += 1;
	}

	@Override
	public void select() {
		Query query = em.createQuery("from UsersHibernateEntity");
		List<hibernateEntity> list = (ArrayList<hibernateEntity>) query.getResultList();

	}

	@Override
	public void update() {
		em.getTransaction().begin();
		em.createQuery(
				" update hibernateEntity u set u.datesdituation = :datesdituation, u.cas_semaine = :cas_semaine, u.deces_semaine = :deces_semaine where u.codepays = :codepays")
				.setParameter("codepays", "MAR").setParameter("datesdituation", "14072022")
				.setParameter("cas_semaine",87541).setParameter("deces_semaine", 874)
				.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void delete() {
		em.getTransaction().begin();
		em.createQuery("delete from hibernateEntity where codepays = :codepays").setParameter("codepays", "MAR")
				.executeUpdate();
		em.getTransaction().commit();

	}

}
