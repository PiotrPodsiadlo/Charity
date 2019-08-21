package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryDto;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionService;

import javax.validation.Valid;

@Controller
public class DonationController {


    InstitutionService institutionService;
    DonationService donationService;
    CategoryService categoryService;

    @Autowired
    public DonationController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }


    @GetMapping("/donate")
    public String startDonate(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        model.addAttribute("donationDto", new DonationDto());
        return "form";
    }

    @PostMapping("/donate")
    public String confirmDonation(@Valid DonationDto donationDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/donate";
        }
        donationService.save(donationDto);
        return "form-confirmation";
    }

}
