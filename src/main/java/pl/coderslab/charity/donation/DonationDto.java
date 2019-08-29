package pl.coderslab.charity.donation;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.validator.RefersToFuture;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDto {

    @Min(value = 1, message = "należy wydac co najmniej jeden worek")
    private int quantity;
    private List<Long> categories;
    @NotNull(message="Należy wybrać jedną organizację")
    private Long institution;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "^\\d\\d-\\d\\d\\d$", message = "podaj poprawny kod pocztowy")
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    @Size(min = 9, max = 13, message = "podaj nr telefonu 9 - 13 cyfr")
    private String phoneNumber;
    @RefersToFuture(requiredDifferenceInHours = 12)
    private String dt;

}


