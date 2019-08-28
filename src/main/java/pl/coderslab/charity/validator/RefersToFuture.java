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
    String message() default "{not a more than 24hrs later date}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
