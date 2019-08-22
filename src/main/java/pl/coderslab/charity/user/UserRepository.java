package pl.coderslab.charity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.institution.Institution;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    public User findFirstByEmail(String email);
}
