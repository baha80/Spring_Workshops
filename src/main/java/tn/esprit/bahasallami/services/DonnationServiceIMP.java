package tn.esprit.bahasallami.services;

import tn.esprit.bahasallami.entities.Donation;
import tn.esprit.bahasallami.entities.DonationType;
import tn.esprit.bahasallami.repository.Donationrepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class DonnationServiceIMP implements IDonnation{

    private Donationrepository donnationRepository;
    @Override
    public Donation addDonation(Donation donation) {
        if (!"MONETARY".equals(donation.getDonType())) {
            donation.setDonAmount(0);
        }
        return donnationRepository.save(donation);
    }
//stream() is a method of the Collection interface. It returns a sequential stream considering collection as its source.
    @Override
    public Set<Donation> getDonationByType(DonationType type) {
        return donnationRepository.findAll().stream()
                .filter(d -> d.getDonType().equals(type))
                .collect(Collectors.toSet());


    }

    @Override
    public Float getTotalDonation(Date date1, Date date2) {
        Float total = donnationRepository.sumDonationsBetweenDates(date1, date2);
        return total != null ? total : 0;
    }
}
