package pl.coderslab.charity.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.donation.DonationDto;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid UserDto userDto, BindingResult result, Model model, @RequestParam String password2){
        if (result.hasErrors()) {
            return "register";
        }
        User existingUserEmail = userService.findFirstByEmail(userDto.getEmail());
        if (existingUserEmail != null) {
            result.addError(new FieldError("user",  "email",
                    "Podany e-mail jest już zajęty"));
            return "register";
        }
        User existingUsername = userService.findFirstByUsername(userDto.getUsername());
        if (existingUsername != null) {
            result.addError(new FieldError("user",  "username",
                    "Podana nazwa uzytkownika jest już zajęta"));
            return "register";
        }

        if (!userDto.getPassword().equals(password2)) {
            result.addError(new FieldError("user", "password",
                    "Hasła różnią się od siebie"));
            return "register";
        }
        userService.save(userDto);
        return "redirect:/";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }


}
