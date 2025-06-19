package com.devsuperior.bds04.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.devsuperior.bds04.controllers.exceptions.FieldMessage;
import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.dto.UserInsertDTO;
import com.devsuperior.bds04.dto.UserUpdateDTO;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserUpdateValidator implements ConstraintValidator<UserUpdatetValid, UserUpdateDTO>{
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserUpdateValid ann) {
		
	}
	
	@Override
	public boolean isValid(UserUpdatetDTO dto, ConstraintValidatorContext context) {
		
		var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long userId = Long.parseLong(uriVars.getClass());
		List<FieldMessage> list = new ArrayList<>();
		
		User user = repository.findByFirstName(dto.getFirstName());
		if(user != null) {
			list.add(new FieldMessage("firstName", "Campo requeirdo"));
		}

		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFiledName())
					.addConstraintViolation();
			
		}
		return list.isEmpty();
	}

}
