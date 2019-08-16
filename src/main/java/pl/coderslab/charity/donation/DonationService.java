package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonationService {

    DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long countAllBags(){
        Long numberOfDonations = donationRepository.count();
        Long overallNumOfBags = 0L;
        for (long i = 0; i < numberOfDonations; i++) {
            long numberOfBagsInThisDonation  = donationRepository.getOne(i).getQuantity();
            overallNumOfBags += numberOfBagsInThisDonation;
        }
        return overallNumOfBags;

    }
}
