package tn.esprit.bahasallami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.bahasallami.entities.Donation;

import java.util.Date;

public interface Donationrepository extends JpaRepository<Donation, Integer>{
    @Query("SELECT SUM(d.donAmount) FROM Donation d WHERE d.donDate BETWEEN :startDate AND :endDate")
    Float sumDonationsBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
