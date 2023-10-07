/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListTask;

public class ListTaskHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TaskManagerWithOwners");
	
	public void insertTask(ListTask li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListTask> showAllTasks(){
		EntityManager em = emfactory.createEntityManager();
		List<ListTask> allTasks = em.createQuery("SELECT i from ListTask i").getResultList();
		return allTasks;
		
	}

	public void deleteTask(ListTask toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select lt from ListTask lt where lt.title = :selectedTitle and lt.description = :selectedDescription and lt.status = :selectedStatus", ListTask.class);
		
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		typedQuery.setParameter("selectedStatus", toDelete.getStatus());

		
		typedQuery.setMaxResults(1);
		
		ListTask result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListTask searchForTaskById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		ListTask found = em.find(ListTask.class, idToEdit);
		em.close();
		return found;
	}

	public void updateTask(ListTask toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListTask> searchForTaskByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select lt from ListTask lt where lt.title = :selectedTitle", ListTask.class);
		
		typedQuery.setParameter("selectedTitle", title);
		
		List<ListTask> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}

	public List<ListTask> searchForTaskByDescription(String description) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select lt from ListTask lt where lt.description = :selectedDescription", ListTask.class);
		
		typedQuery.setParameter("selectedDescription", description);
		
		List<ListTask> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}
	
	public List<ListTask> searchForTaskByStatus(String status) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select lt from ListTask lt where lt.status = :selectedStatus", ListTask.class);
		
		typedQuery.setParameter("selectedStatus", status);
		
		List<ListTask> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}