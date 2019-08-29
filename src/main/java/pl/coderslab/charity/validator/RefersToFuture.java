package pl.coderslab.charity.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FutureStringValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public  @interface RefersToFuture {
    int requiredDifferenceInHours();
    String message() default "please chose pick up time at least 12 hours from now";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

