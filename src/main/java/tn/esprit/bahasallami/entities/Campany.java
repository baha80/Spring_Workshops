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
public class Campany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campanyId;
    private String campanyName;
    private String adress;

    @OneToMany(mappedBy = "company") //FK f inscri
    private Set<Employe> employes;
}
