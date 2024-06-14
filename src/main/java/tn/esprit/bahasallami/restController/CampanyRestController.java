package tn.esprit.bahasallami.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bahasallami.entities.Campany;
import tn.esprit.bahasallami.services.ICampany;
@AllArgsConstructor
@RestController
public class CampanyRestController {

    private ICampany icampanyService;

    @PostMapping("/addCampany")
    public Campany addCampany(@RequestBody Campany campany){
        return icampanyService.addCampany(campany);
    }

}
