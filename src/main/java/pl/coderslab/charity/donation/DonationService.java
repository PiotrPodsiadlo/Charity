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

    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @Autowired


    public Long countAllBags(){
        Long numberOfDonations = donationRepository.count();
        Long overallNumOfBags = 0L;
        for (long i = 0; i < numberOfDonations; i++) {
            long numberOfBagsInThisDonation  = donationRepository.getOne(i).getQuantity();
            overallNumOfBags += numberOfBagsInThisDonation;
        }
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
