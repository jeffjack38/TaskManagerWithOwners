package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tasks")
public class ListTask {
	//set variables
		@Id
		@GeneratedValue
		@Column(name="ID")
	    private int id;
		@Column(name="TITLE")
	    private String title;
		@Column(name="DESCRIPTION")
	    private String description;
		@Column(name="STATUS")
	    private String status;
	    
	    
	    //no arg constructor
	    public ListTask() {
	    	super();
	    }

	    //constructor
	    public ListTask(int id, String title, String description, String status) {
	        this.id = id;
	        this.title = title;
	        this.description = description;
	        this.status = status;
	    }
	    
	    public ListTask(String title, String description, String status) {
	    	this.title = title;
	        this.description = description;
	        this.status = status;
	    }
	    
	    // Getters and setters
		
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		public String returnTaskDetails( ) {
			return title + ": " + description + ": " + status;
		}
		
	}

