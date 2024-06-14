package tn.esprit.bahasallami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.bahasallami.entities.Donation;
import tn.esprit.bahasallami.entities.DonationType;

import java.util.Date;
import java.util.List;

public interface Donationrepository extends JpaRepository<Donation, Integer>{
    //get donations by type
    public List<Donation> findByDonType(DonationType type);
    @Query("SELECT SUM(d.donAmount) FROM Donation d WHERE d.donDate BETWEEN :startDate AND :endDate")
    Float sumDonationsBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
