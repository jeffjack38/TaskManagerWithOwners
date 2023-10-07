/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 6, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="OWNERNAME")
	private String ownerName;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Owner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}

	public Owner(int id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", ownerName=" + ownerName + "]";
	}
	
	
	

}
