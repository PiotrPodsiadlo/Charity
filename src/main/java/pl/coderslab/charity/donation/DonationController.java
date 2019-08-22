package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryDto;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {


    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    @Autowired
    public DonationController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }
    @ModelAttribute("categories")
    public List<Category> getAllCategories(){return categoryService.findAll();}
    @ModelAttribute("institutions")
    public List<Institution> getAllInstitutions(){return institutionService.findAllInstitutions();}


    @GetMapping("/donate")
    public String startDonate(Model model) {
        model.addAttribute("donationDto", new DonationDto());
        return "form";
    }

    @PostMapping("/donate")
    public String confirmDonation(@Valid DonationDto donationDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
//            return "redirect:/donate"; //zostawiam jako komentarz żeby przetestować z Tomkiem Laciną
            return "form";
        }
        donationService.save(donationDto);
        return "form-confirmation";
    }

}
