package pl.coderslab.charity.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.donation.DonationDto;

@Controller
public class UserController {

    @GetMapping("/register")
    public String startDonate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }



    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
