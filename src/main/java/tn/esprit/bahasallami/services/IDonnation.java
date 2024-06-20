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
//the difference between set and List is that List is an ordered collection, and you access elements by their index,
// which is an integer value that starts with 0.
// Set is an unordered collection, so you cannot access elements by their index.
// You can access elements by their value, but the value must be unique.
// If you try to add an element that already exists in the Set, the Set will not add the element.