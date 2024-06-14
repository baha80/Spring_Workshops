package tn.esprit.bahasallami.services;

import tn.esprit.bahasallami.entities.Employe;

import java.util.List;

public interface IEmploye {

    public Employe addEmployeAndAssignToCompany(Employe employe, String campanyName);

    public void getEmployeByDonation() ;

    public List<Employe> getEmployeByArea(String companyName , String area) ;




}
