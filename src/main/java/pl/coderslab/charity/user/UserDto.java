package pl.coderslab.charity.user;

import lombok.Data;
import pl.coderslab.charity.donation.Donation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private List<String> donations = new ArrayList<>();
    private boolean active;
    private Set<String> roles = new HashSet<>();
}
