package tn.esprit.bahasallami.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.bahasallami.entities.Campany;
import tn.esprit.bahasallami.entities.Employe;
import tn.esprit.bahasallami.entities.RedCrescent;
import tn.esprit.bahasallami.repository.CampanyRepository;
import tn.esprit.bahasallami.repository.EmployeRepository;
import tn.esprit.bahasallami.repository.IRedCrescentRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeServiceIMP implements IEmploye{

    private CampanyRepository icampanyRepository;
    private EmployeRepository iemployeRepository;
    private IRedCrescentRepository iRedCrescentRepository;
//    @Override
//    public Employe addEmployeAndAssignToCompany(Employe employe, String campanyName) {
//        Campany campany = icampanyRepository.findAll().stream().filter(c -> c.getCampanyName().equals(campanyName)).findFirst().get();
//        employe.setCompany(campany);
//        return iemployeRepository.save(employe);
//
//    }
     @Override
        public Employe addEmployeAndAssignToCompany(Employe employe, String campanyName) {
        Campany campany = icampanyRepository.findAll().stream()
        .filter(c -> c.getCampanyName().equals(campanyName))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("No company found with name: " + campanyName));
    employe.setCompany(campany);
    return iemployeRepository.save(employe);
    }

//Question 6 : Create a method that returns the employee who made the most donations in a given month.
    @Override
    @Scheduled(cron = "0 0 0 1 * ?") // run at midnight on the first day of every month
    public void getEmployeByDonation() {
        LocalDate now = LocalDate.now();
        LocalDate startOfMonth = now.withDayOfMonth(1);
        LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());

        Optional<Employe> bestEmployee = iemployeRepository.findAll().stream()
                .filter(e -> e.getDonations().stream()
                        .anyMatch(d -> LocalDate.parse(d.getDonDate()).isAfter(startOfMonth) && LocalDate.parse(d.getDonDate()).isBefore(endOfMonth)))
                .max(Comparator.comparingInt(e -> (int) e.getDonations().stream()
                        .filter(d -> LocalDate.parse(d.getDonDate()).isAfter(startOfMonth) && LocalDate.parse(d.getDonDate()).isBefore(endOfMonth))
                        .count()));

        bestEmployee.ifPresent(e -> System.out.println("Best employee of the month: " + e.getFirstName())); // or any other existing method to get the employee's name
    }

    @Override
    public List<Employe> getEmployeByArea(String companyName, String area) {
        List<RedCrescent> redCrescentsInArea = iRedCrescentRepository.findAll().stream()
                .filter(rc -> rc.getArea().equals(area))
                .toList();// get all red crescents in the area

        return iemployeRepository.findAll().stream()
                .filter(e -> e.getCompany().getCampanyName().equals(companyName))
                .toList();
    }
}
