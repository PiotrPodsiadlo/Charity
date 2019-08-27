package pl.coderslab.charity.valdidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FutureStringValidator implements ConstraintValidator<RefersToFuture, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }


}
