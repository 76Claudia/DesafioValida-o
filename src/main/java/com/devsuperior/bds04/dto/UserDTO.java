package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.bds04.entities.User;

public class UserDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
	private String lastName;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String firstName, String lastName) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	
	}
	
	public UserDTO(User entity) {
	    id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

}
