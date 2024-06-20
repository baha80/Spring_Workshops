package tn.esprit.bahasallami.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bahasallami.entities.Donation;
import tn.esprit.bahasallami.entities.DonationType;
import tn.esprit.bahasallami.services.IDonnation;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@RestController
public class DonnationRestController {

    private IDonnation iDonnationService;

    //add donation
    @PostMapping("/addDonnation")
    public Donation addDonnation(@RequestBody Donation donation){
        return iDonnationService.addDonation(donation);
    }

    //get aboonement by type
    @GetMapping("/getDonnationByType/{type}")
    public List<Donation> findByDonType(@PathVariable DonationType type){
        return iDonnationService.getDonationByType(type);
    }
    //get total donation
    @GetMapping("/getTotalDonnation/{date1}/{date2}")
    public Float getTotalDonnation(@PathVariable Date date1, @PathVariable Date date2){
        return iDonnationService.getTotalDonation(date1, date2);
    }
}

