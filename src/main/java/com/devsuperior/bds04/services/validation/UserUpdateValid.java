package com.devsuperior.bds04.services.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = UserInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface UserUpdateValid {
		String message() default "Validation error";
		
		Class<?>[] groups() default {};
		
		Class<? extends Payload>[]payload() default{};
}
