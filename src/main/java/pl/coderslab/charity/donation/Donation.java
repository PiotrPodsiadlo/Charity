package pl.coderslab.charity.donation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToMany
    private List<Category> categories;
    @ManyToOne
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private String phoneNumber;


}
