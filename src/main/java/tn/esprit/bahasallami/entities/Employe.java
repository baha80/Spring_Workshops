package tn.esprit.bahasallami.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Employe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeId;
    private String lastName;
    private String firstName;
    private String position;
    @ManyToOne
    private Campany company;

    //relation avec Donation employee 1..*
    @OneToMany(mappedBy = "employe")
    private Set<Donation> donations;


}
