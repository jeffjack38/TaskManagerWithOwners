/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity

public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate taskDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListTask> listOfTasks;
	
	public ListDetails(int id, String listName, LocalDate taskDate, Owner owner, List<ListTask> listOfTasks ) {
		
	}

	public ListDetails(String listName, LocalDate taskDate, Owner owner) {
		super();
		this.listName = listName;
		this.taskDate = taskDate;
		this.owner = owner;
	}

	public ListDetails(String listName, LocalDate taskDate, Owner owner, List<ListTask> listOfTasks) {
		super();
		this.listName = listName;
		this.taskDate = taskDate;
		this.owner = owner;
		this.listOfTasks = listOfTasks;
	}

	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", taskDate=" + taskDate + ", owner=" + owner
				+ ", listOfTasks=" + listOfTasks + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<ListTask> getListOfTasks() {
		return listOfTasks;
	}

	public void setListOfTasks(List<ListTask> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}

}
