package tn.esprit.bahasallami.restController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bahasallami.entities.Employe;
import tn.esprit.bahasallami.services.IEmploye;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeRestController {
    private IEmploye iemployeService;

    @PostMapping("/addEmploye")
    public Employe addEmployeAndAssignToCompany(@RequestBody Employe employe, @RequestParam String campanyName) {
        return iemployeService.addEmployeAndAssignToCompany(employe, campanyName);
    }

    @GetMapping("/best-donator")
    public void getEmployeByDonation() {
        iemployeService.getEmployeByDonation();

    }
//ToBeChecked
    @GetMapping("/by-area")
    public ResponseEntity<List<Employe>> getEmployeByArea(@RequestParam String companyName, @RequestParam String area) {
        List<Employe> employes = iemployeService.getEmployeByArea(companyName, area);
        return ResponseEntity.ok(employes);
    }
}
