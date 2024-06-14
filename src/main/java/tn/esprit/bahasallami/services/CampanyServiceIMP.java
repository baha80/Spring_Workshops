package tn.esprit.bahasallami.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.bahasallami.entities.Campany;
import tn.esprit.bahasallami.repository.CampanyRepository;
@Service
@AllArgsConstructor
public class CampanyServiceIMP implements ICampany{

    private CampanyRepository campanyRepository;

    @Override
    public Campany addCampany(Campany campany) {
        return campanyRepository.save(campany);
    }
}
