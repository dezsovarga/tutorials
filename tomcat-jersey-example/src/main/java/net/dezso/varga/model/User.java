package net.dezso.varga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dezso.varga on 3/3/2015.
 */
@Entity
@Table(name = "user_")
@XmlRootElement
public class User {
	@Id
	@Column(name = "userId")
	private Long id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	public long getId() {
		return id;
	}
	@XmlElement
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
