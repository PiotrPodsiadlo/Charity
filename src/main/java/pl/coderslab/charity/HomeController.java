package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;

    @Autowired
    public HomeController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }


    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        model.addAttribute("trashbags", donationService.countAllBags());
        model.addAttribute("institutionsCount", institutionService.findAllInstitutions().size());
        return "index";
    }
}
