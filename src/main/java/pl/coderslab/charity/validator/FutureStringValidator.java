package pl.coderslab.charity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FutureStringValidator implements ConstraintValidator<RefersToFuture, String> {

    private int requiredTimeDifference;

    @Override
    public void initialize(RefersToFuture constraintAnnotation) {
        this.requiredTimeDifference = constraintAnnotation.requiredDifferenceInHours();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTimefromString = LocalDateTime.parse(value, formatter);
        Duration duration = Duration.between(now, dateTimefromString);
        long differenceBetweenNowAndPickUptime = duration.toHours();
        return differenceBetweenNowAndPickUptime > requiredTimeDifference;

    }
}
