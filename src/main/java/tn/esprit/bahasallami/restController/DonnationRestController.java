package tn.esprit.bahasallami.restController;

import org.springframework.web.bind.annotation.GetMapping;
import tn.esprit.bahasallami.entities.Donation;
import tn.esprit.bahasallami.services.IDonnation;

import java.util.List;

public class DonnationRestController {

    private IDonnation iDonnationService;
    //get aboonement by type
    @GetMapping("/getDonnationByType")
    public List<Donation> findByDonType(){
        return iDonnationService.getDonationByType(t);
    }
}
