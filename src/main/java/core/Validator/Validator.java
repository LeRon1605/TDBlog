package core.Validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class Validator {
	public static <T>ValidateResult validate(T obj) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<T>> result = validator.validate(obj);
		if (result.isEmpty()) 
			return new ValidateResult(true);
		
		String[] messages = new String[result.size()];
		int i = 0;
		for (ConstraintViolation<T> violation: result) 
			messages[i++] = violation.getMessage();
		return new ValidateResult(false, messages);
	}
}
