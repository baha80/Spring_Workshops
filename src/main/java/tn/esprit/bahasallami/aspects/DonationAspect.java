package tn.esprit.bahasallami.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DonationAspect {

    @After("execution(* tn.esprit.bahasallami.services.*.addDonation(..))")
    public void thankYouForDonation() {
        System.out.println("Merci pour ce don");
    }
}