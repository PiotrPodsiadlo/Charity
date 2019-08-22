package pl.coderslab.charity.user;

import com.sun.xml.internal.bind.v2.TODO;
import lombok.Data;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.role.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @OneToMany
    private List<Donation> donations = new ArrayList<>();
    private boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
}
