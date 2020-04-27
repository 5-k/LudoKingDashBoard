package com.prateek.springservice.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Spring Entity Class : auto generate using generate ddl as true, or run the SQL Scripts in resource folder
 * @author prateek.mishra
 *
 */
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="short_description",nullable=false)
	private String short_description;
	
	@Column(name="descripion",nullable=false)
	private String descripion;

	@Column(name="email")
	private String email;

	public User() {
	}

	public User(int id, String name, String short_description, String descripion, String email) {
		this.id = id;
		this.name = name;
		this.short_description = short_description;
		this.descripion = descripion;
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_description() {
		return this.short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDescripion() {
		return this.descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User id(int id) {
		this.id = id;
		return this;
	}

	public User name(String name) {
		this.name = name;
		return this;
	}

	public User short_description(String short_description) {
		this.short_description = short_description;
		return this;
	}

	public User descripion(String descripion) {
		this.descripion = descripion;
		return this;
	}

	public User email(String email) {
		this.email = email;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof User)) {
			return false;
		}
		User user = (User) o;
		return id == user.id && Objects.equals(name, user.name) && Objects.equals(short_description, user.short_description) && Objects.equals(descripion, user.descripion) && Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, short_description, descripion, email);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", name='" + getName() + "'" +
			", short_description='" + getShort_description() + "'" +
			", descripion='" + getDescripion() + "'" +
			", email='" + getEmail() + "'" +
			"}";
	}


}