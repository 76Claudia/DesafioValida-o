package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.bds04.entities.User;

import jakarta.validation.constraints.NotBlank;


public class UserDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String firstName;
	private String lastName;
	private String password;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	
	}
	
	public UserDTO(User entity) {
	    id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		password = entity.getPassword();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
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
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

}
