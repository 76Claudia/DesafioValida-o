package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO{
	public UserUpdateDTO(User entity) {
		
	}

	private static final long serialVersionUID = 1L;
}
