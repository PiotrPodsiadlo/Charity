package pl.coderslab.charity.user;

import lombok.Data;
import pl.coderslab.charity.donation.Donation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
//    TODO private List<Donation> donations = new ArrayList<>();
    private boolean active;
//    TODO private Set<Role> roles = new HashSet<>();
}
