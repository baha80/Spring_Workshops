package tn.esprit.bahasallami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bahasallami.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
