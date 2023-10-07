/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TaskManagerWithOwners");

	public void insertShopper(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Owner> showAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT o from Owner o").getResultList();
		return allOwners;
	}
	
	public Owner findOwner(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select ow from Owner ow where ow.ownerName = :selectedName",Owner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Owner foundOwner;
		try {
			foundOwner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundOwner = new Owner(nameToLookUp);
		}
		em.close();

		return foundOwner;
	}
}