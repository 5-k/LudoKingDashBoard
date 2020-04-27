package com.prateek.springservice.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author prateek.mishra
 * Dto class for data transfer
 * Builder Pattern used
 */
public class UserDto implements Serializable {

	private static final long serialVersionUID = 6669303311756425027L;

	private int id;
	private String name;
	private String short_description;
	private String descripion;
	private String email;
	private int totalPoints;


	public UserDto() {
	}

	public UserDto(int id, String name, String short_description, String descripion, String email, int totalPoints) {
		this.id = id;
		this.name = name;
		this.short_description = short_description;
		this.descripion = descripion;
		this.email = email;
		this.totalPoints = totalPoints;
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

	public int getTotalPoints() {
		return this.totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public UserDto id(int id) {
		this.id = id;
		return this;
	}

	public UserDto name(String name) {
		this.name = name;
		return this;
	}

	public UserDto short_description(String short_description) {
		this.short_description = short_description;
		return this;
	}

	public UserDto descripion(String descripion) {
		this.descripion = descripion;
		return this;
	}

	public UserDto email(String email) {
		this.email = email;
		return this;
	}

	public UserDto totalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof UserDto)) {
			return false;
		}
		UserDto userDto = (UserDto) o;
		return id == userDto.id && Objects.equals(name, userDto.name) && Objects.equals(short_description, userDto.short_description) && Objects.equals(descripion, userDto.descripion) && Objects.equals(email, userDto.email) && totalPoints == userDto.totalPoints;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, short_description, descripion, email, totalPoints);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", name='" + getName() + "'" +
			", short_description='" + getShort_description() + "'" +
			", descripion='" + getDescripion() + "'" +
			", email='" + getEmail() + "'" +
			", totalPoints='" + getTotalPoints() + "'" +
			"}";
	}

	
}
