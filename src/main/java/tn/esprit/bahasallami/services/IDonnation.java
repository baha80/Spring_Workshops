package tn.esprit.bahasallami.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.bahasallami.entities.Donation;
import tn.esprit.bahasallami.entities.DonationType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

    public interface IDonnation {

    public Donation addDonation(Donation donation);

    public List<Donation> getDonationByType(DonationType type) ;

    public Float getTotalDonation(Date date1, Date date2);
}