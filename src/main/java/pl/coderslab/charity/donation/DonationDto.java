package pl.coderslab.charity.donation;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDto {

    @Min(value = 1)
    private int quantity;
    private List<Long> categories;
    @NotNull
    private Long institution;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private LocalDate pickUpDate;
    @Future
    private LocalTime pickUpTime;
    private String pickUpComment;
    @NotBlank
    private String phoneNumber;


}
