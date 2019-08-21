package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;

@Service
@Transactional
public class DonationService {

    DonationRepository donationRepository;
    CategoryRepository categoryRepository;
    InstitutionRepository institutionRepository;


    @Autowired
    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }




    public Integer countAllBags(){
        List<Donation> allDonations = donationRepository.findAll();
        int donationCount = allDonations.size();
        Integer overallNumOfBags = allDonations.stream().map(elem -> elem.getQuantity()).reduce(0, Integer::sum);
        return overallNumOfBags;
    }


    public void save(DonationDto donationDto){

        Donation donation = new Donation();
        donation.setQuantity(donationDto.getQuantity());
        donation.setCategories(categoryRepository.findAllById(donationDto.getCategories()));
        donation.setInstitution(institutionRepository.getOne(donationDto.getInstitution()));
        donation.setStreet(donationDto.getStreet());
        donation.setCity(donationDto.getCity());
        donation.setZipCode(donationDto.getZipCode());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());
        donation.setPickUpComment(donationDto.getPickUpComment());
        donation.setPhoneNumber(donationDto.getPhoneNumber());
        donationRepository.save(donation);
    }
}
