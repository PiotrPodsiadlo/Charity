package pl.coderslab.charity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FutureStringValidator implements ConstraintValidator<RefersToFuture, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTimefromString = LocalDateTime.parse(value, formatter);
        System.out.println(dateTimefromString);
        return true;
    }
}
