package it.gov.aifa.invoice_processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

public abstract class AbstractTest {
	
	public enum ValidationType{
		CONSTRUCTOR
		, METHOD
	}
	
	@SafeVarargs
	public final <T,A> void validationTest(
			ValidationType validationType
			, String methodName
			, Class<?>[] parameterTypes
			, T objectToTest
			, Class<T> objectToTestType
			, Object[] parameterValues
			, Class<? extends Annotation>... expectedViolationTypes
			) throws Exception{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		ExecutableValidator executableValidator = factory.getValidator().forExecutables();
		Set<ConstraintViolation<T>> violations;
		switch(validationType) {
		case CONSTRUCTOR:
			violations = executableValidator.validateConstructorParameters(
					objectToTestType.getConstructor(parameterTypes)
					, parameterValues);
			break;
		case METHOD:
			violations = executableValidator.validateParameters(
					objectToTest,
					objectToTestType.getMethod(methodName, parameterTypes),
					parameterValues
					);
			break;
		default:
			throw new RuntimeException("A validation type must be specified");
		}
		
		Set<Class<? extends Annotation>> violationTypes = new HashSet<>(violations.size());
		for(ConstraintViolation<T> violation : violations) {
			violationTypes.add(
					violation
					.getConstraintDescriptor()
					.getAnnotation()
					.annotationType()
					);			
		}
		Set<Class<? extends Annotation>> expectedViolationCollection = new HashSet<>(Arrays.asList(expectedViolationTypes));
		assertThat(violationTypes).containsExactlyElementsOf(expectedViolationCollection);
	}
}
